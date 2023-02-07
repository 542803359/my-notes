package com.xiaowenxing.demo.controller;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

/**
 * @author XWX
 * @date 2021/4/30 14:03
 * @since 3.2
 **/
@RestController
@RequestMapping("/test")
public class DockerTestController {

    @GetMapping("/helloDocker")
    public String helloDocker() {
        return "hello docker";
    }

    public static void main(String[] args) {

        String timeZone = "+8";

        //前端传入活动开始时间,转为UTC+0的时间蹉,存入数据库
        //activityMilli代表的是UTC+0时区的2023-01-05 18:00:00时间
        LocalDateTime time = LocalDateTime.of(2023, 1, 28, 8, 0, 0);
        long activityMilli = time.toInstant(ZoneOffset.of("+0")).toEpochMilli();
        System.out.println(activityMilli);

        //从mysql取出活动开始的时间蹉,并传入时区偏移量,获得当前时区活动开始时间
        OffsetDateTime offsetDateTime =
                LocalDateTime.ofEpochSecond(1673632800000L / 1000, 0, ZoneOffset.ofHours(0))
                        .atOffset(ZoneOffset.of(timeZone));
        System.out.println(offsetDateTime.toEpochSecond());
        //获取用户当前时区的时间蹉
        OffsetDateTime now = Instant.now().atOffset(ZoneOffset.of(timeZone));
        System.out.println(now.toEpochSecond());
        System.out.println(Instant.now().toEpochMilli() / 1000);

        //比较器值，小于则为负，大于则为正
        int i = now.compareTo(offsetDateTime);
        System.out.println(i);

        LocalDateTime startTime = LocalDateTime.now();
        LocalDateTime localDateTime = LocalDateTime.now().plusHours(1);

        System.out.println(startTime.toInstant(ZoneOffset.of("-8")).toEpochMilli());
        System.out.println(startTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(Instant.now().toEpochMilli());
        System.out.println(localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli());
        System.out.println(localDateTime.toInstant(ZoneOffset.of("-8")).toEpochMilli());

        LocalDateTime time3 =LocalDateTime.ofEpochSecond(Instant.now().toEpochMilli()/1000,
                0,ZoneOffset.ofHoursMinutes(-4,-30));
        System.out.println(time3);
        LocalDateTime time4 =LocalDateTime.ofEpochSecond(Instant.now().toEpochMilli()/1000,
                0,ZoneOffset.ofHoursMinutes(+8,30));
        System.out.println(time4);

        LocalDateTime time2 =LocalDateTime.ofEpochSecond(1673632800000L/1000,0,ZoneOffset.ofHours(0));
        System.out.println(time2);
    }

}
