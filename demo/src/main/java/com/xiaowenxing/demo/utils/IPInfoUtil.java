package com.xiaowenxing.demo.utils;

import com.jthinking.common.util.ip.IPInfo;
import com.jthinking.common.util.ip.IPInfoUtils;

/**
 * ipinfo工具类
 *
 * @author xiaowx
 * @date 2023/02/03 17:43:05
 */
public class IPInfoUtil {

    public static void main(String[] args) {
        IPInfo ipInfo = IPInfoUtils.getIpInfo("178.249.213.97");
        // 国家中文名称
        System.out.println(ipInfo.getCountry());
        // 中国省份中文名称
        System.out.println(ipInfo.getProvince());
        // 详细地址
        System.out.println(ipInfo.getAddress());
        // 互联网服务提供商
        System.out.println(ipInfo.getIsp());
        // 是否是国外
        System.out.println(ipInfo.isOverseas());
        // 纬度
        System.out.println(ipInfo.getLat());
        // 经度
        System.out.println(ipInfo.getLng());

        for (int i = 0; i < 10; i++) {
            System.out.println(IPInfoUtils.getIpInfo("2.56.9." + i));
        }
    }
}
