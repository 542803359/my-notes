package com.xiaowenxing.ipregion.utils;

import com.jthinking.common.util.ip.IPInfo;
import com.jthinking.common.util.ip.IPInfoUtils;

/**
 * ipinfo工具类
 *
 * @author xiaowx
 * @date 2023/02/03 17:43:05
 */
public class IPInfoUtil {

    /**
     * https://gitee.com/jthinking/ip-info?_from=gitee_search
     * IP地理位置获取。支持获取IPv4、IPv6地址信息。包括：国家中文名称、中国省份中文名称、详细地址、互联网服务提供商、是否是国外、纬度、经度。
     */

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
    }

    public static String getIpInfo(String ip) {
        IPInfo ipInfo = IPInfoUtils.getIpInfo(ip);
        return ipInfo.getCountry() + "|" + ipInfo.isOverseas();
    }
}
