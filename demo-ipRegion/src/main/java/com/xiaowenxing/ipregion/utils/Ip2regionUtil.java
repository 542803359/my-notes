package com.xiaowenxing.ipregion.utils;

import org.lionsoul.ip2region.xdb.Searcher;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;


/**
 * ip2region工具类
 *
 * @author xiaowx
 * @date 2023/02/03 17:17:45
 */
public class Ip2regionUtil {

    /**
     * https://github.com/lionsoul2014/ip2region
     * <p>
     * ip2region v2.0 - 是一个离线IP地址定位库和IP定位数据管理框架，10微秒级别的查询效率，提供了众多主流编程语言的 xdb 数据生成和查询客户端实现
     * </p>
     * <p>
     * 我们也可以预先加载整个 ip2region.xdb 的数据到内存，然后基于这个数据创建查询对象来实现完全基于文件的查询，类似之前的 memory search。
     * </p>
     */

    public static byte[] cBuff;

    static {
        Resource resource = new ClassPathResource("ip2region.xdb");
        String dbPath = null;
        try {
            dbPath = resource.getFile().getPath();
            System.out.println(dbPath);

            // 从 dbPath 加载整个 xdb 到内存。
            cBuff = Searcher.loadContentFromFile(dbPath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getIpInfo(String ip) {
        String region = "";
        try {
            // 使用上述的 cBuff 创建一个完全基于内存的查询对象。
            Searcher searcher = Searcher.newWithBuffer(cBuff);
            // 3、查询
            region = searcher.search(ip);
            System.out.println(region);
        } catch (Exception e) {
            System.out.printf("failed to search(%s): %s\n", ip, e);
        }
        return region;
        // 备注：并发使用，用整个 xdb 数据缓存创建的查询对象可以安全的用于并发，也就是你可以把这个 searcher 对象做成全局对象去跨线程访问。
    }


}
