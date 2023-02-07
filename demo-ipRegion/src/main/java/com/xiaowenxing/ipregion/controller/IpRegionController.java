package com.xiaowenxing.ipregion.controller;

import com.xiaowenxing.ipregion.domin.TimeZoneDto;
import com.xiaowenxing.ipregion.utils.GeoLiteCountryUtil;
import com.xiaowenxing.ipregion.utils.IPInfoUtil;
import com.xiaowenxing.ipregion.utils.Ip2regionUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ip区域控制器
 *
 * @author xiaowx
 * @date 2023/02/07 14:15:19
 */
@RestController
@RequestMapping("/ipRegion")
public class IpRegionController {

    /**
     * 使用GeoLite2获取ip信息
     */
    @GetMapping("/geoLite")
    public TimeZoneDto geoLite(@RequestParam String ip) {
        TimeZoneDto countryInfo = GeoLiteCountryUtil.getCountryInfo(ip);
        return countryInfo;
    }

    /**
     * 使用ip2region获取ip信息
     */
    @GetMapping("/ip2region")
    public String ip2region(@RequestParam String ip) {
        String countryInfo = Ip2regionUtil.getIpInfo(ip);
        return countryInfo;
    }

    /**
     * 使用ipInfo获取ip信息
     */
    @GetMapping("/ipInfo")
    public String ipInfo(@RequestParam String ip) {
        String countryInfo = IPInfoUtil.getIpInfo(ip);
        return countryInfo;
    }

}
