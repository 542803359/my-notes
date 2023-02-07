package com.xiaowenxing.demo.utils;

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


    public static void main(String[] args) throws IOException {

        // 使用上述的 cBuff 创建一个完全基于内存的查询对象。
        Searcher searcher = Searcher.newWithBuffer(cBuff);
        String ip = "5.22.240.0";
        // 3、查询
        try {
            String region = searcher.search(ip);
            System.out.println(region);
        } catch (Exception e) {
            System.out.printf("failed to search(%s): %s\n", ip, e);
        }

        // 备注：并发使用，用整个 xdb 数据缓存创建的查询对象可以安全的用于并发，也就是你可以把这个 searcher 对象做成全局对象去跨线程访问。
    }

}
