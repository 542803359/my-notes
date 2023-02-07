package com.xiaowenxing.ipregion.utils;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.record.*;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.File;
import java.io.IOException;
import java.net.InetAddress;

/**
 * geo lite2工具类
 *
 * @author xiaowx
 * @date 2023/02/03 17:17:56
 */
public class GeoLiteCityUtil {


    private static DatabaseReader reader;

    static {
        Resource resource = new ClassPathResource("GeoLite2-City.mmdb");
        File file = null;
        try {
            file = resource.getFile();
            // 读取数据库内容
            reader = new DatabaseReader.Builder(file).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws IOException, GeoIp2Exception {

        // 访问IP
        String ip = "5.146.23.58";

        //要解析的ip地址
        InetAddress ipAddress = InetAddress.getByName(ip);


        // 获取查询结果
        CityResponse response = reader.city(ipAddress);

        // 获取国家信息
        Country country = response.getCountry();
        System.out.println(country.getIsoCode());
        System.out.println(country.getName());
        System.out.println(country.getNames().get("zh-CN"));

        // 获取省份
        Subdivision subdivision = response.getMostSpecificSubdivision();
        System.out.println(subdivision.getName());
        System.out.println(subdivision.getIsoCode());
        System.out.println(subdivision.getNames().get("zh-CN"));

        // 获取城市
        City city = response.getCity();
        System.out.println(city.getName());
        Postal postal = response.getPostal();
        System.out.println(postal.getCode());
        System.out.println(city.getNames().get("zh-CN"));
        Location location = response.getLocation();
        System.out.println(location.getLatitude());
        System.out.println(location.getLongitude());
    }
}
