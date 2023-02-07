package com.xiaowenxing.demo.utils;

import com.alibaba.fastjson.JSONObject;
import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.AddressNotFoundException;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;
import com.maxmind.geoip2.record.*;
import com.xiaowenxing.demo.domin.TimeZoneDto;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * geo lite2工具类
 *
 * @author xiaowx
 * @date 2023/02/03 17:17:56
 */
@Component
public class GeoLiteCountryUtil {


    private static DatabaseReader reader;

    static {
        Resource resource = new ClassPathResource("GeoLite2-Country.mmdb");
        File file = null;
        try {
            file = resource.getFile();
            // 读取数据库内容
            reader = new DatabaseReader.Builder(file).build();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, TimeZoneDto> TIME_ZONE_MAP = new HashMap<>();

    @PostConstruct
    public void init() {
        String jsonStr = "";
        try {
            Resource resource = new ClassPathResource("Result.json");
            InputStream inputStream = resource.getInputStream();
            Reader reader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
            int ch = 0;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char) ch);
            }
            reader.close();
            jsonStr = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<TimeZoneDto> dtoList = JSONObject.parseArray(jsonStr, TimeZoneDto.class);
        TIME_ZONE_MAP = dtoList.stream().collect(Collectors.toMap(TimeZoneDto::getShorthand, o -> o));

    }

    public static void getCountryInfo(String ip) {
        try {
            //要解析的ip地址
            InetAddress ipAddress = InetAddress.getByName(ip);
            // 获取查询结果
            CountryResponse response = reader.country(ipAddress);
            // 获取国家信息
            Country country = response.getCountry();
            System.out.println(country.getIsoCode());
            System.out.println(country.getName());
            System.out.println(country.getNames().get("zh-CN"));
            TimeZoneDto timeZoneDto = TIME_ZONE_MAP.get(country.getIsoCode());
            System.out.println(timeZoneDto);
        } catch (AddressNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
