package com.example.demostrategy;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.redisson.api.*;
import org.redisson.client.codec.Codec;
import org.redisson.client.codec.IntegerCodec;
import org.redisson.client.codec.StringCodec;
import org.redisson.codec.JsonJacksonCodec;
import org.redisson.codec.SerializationCodec;
import org.redisson.codec.TypedJsonJacksonCodec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.io.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
class DemoStrategyApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("111");
    }

    @Resource
    private RedissonClient redissonClient;

    @Test
    void testSortedSet() {

        String key = "simple";

        RScoredSortedSet<Recommend> scoredSortedSet = redissonClient.getScoredSortedSet(key, new TypedJsonJacksonCodec(Recommend.class));
        scoredSortedSet.expire(180, TimeUnit.SECONDS);

        double min = 5.0;
        double max = 10.0;

        Map<Recommend, Double> map = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            Recommend recommend = new Recommend();
            recommend.setUserId(i);
            double boundedDouble = min + new Random().nextDouble() * (max - min);
            recommend.setWeights(boundedDouble);

            //单个存储
            //scoredSortedSet.add(boundedDouble, recommend);

            //放入map中集中存储
            map.put(recommend, boundedDouble);
        }

        scoredSortedSet.addAll(map);

    }

    @Test
    void getSortedSet() {
        String key = "simple";

        RScoredSortedSet<Recommend> scoredSortedSet = redissonClient.getScoredSortedSet(key, new TypedJsonJacksonCodec(Recommend.class));


        Set<Recommend> strings1 = scoredSortedSet.readSort("score", SortOrder.DESC, 0, 10);


        for (Recommend recommend : strings1) {

            System.out.println(recommend.getUserId());
        }
    }


    @Test
    void testIntSortedSet() {

        String key = "simpleInt";

        RScoredSortedSet<Integer> scoredSortedSet = redissonClient.getScoredSortedSet(key, IntegerCodec.INSTANCE);


        Collection<Integer> integers = scoredSortedSet.readAll();
        ArrayList<Integer> list = new ArrayList<>(integers);
        System.out.println(list);

       /* double min = 5.0;
        double max = 10.0;

        for (int i = 1; i < 10; i++) {

            double boundedDouble = min + new Random().nextDouble() * (max - min);

            scoredSortedSet.add(boundedDouble, i);
        }*/
    }

    @Test
    void getIntSortedSet() {
        String key = "simpleInt";
        RScoredSortedSet<Integer> scoredSortedSet = redissonClient.getScoredSortedSet(key, IntegerCodec.INSTANCE);
        Set<Integer> score = scoredSortedSet.readSort("score", SortOrder.DESC, 0, 5);
        Collection<Integer> integers = scoredSortedSet.valueRange((double) 8, true, (double) 10, true);
        System.out.println(integers);
        System.out.println(score);
        scoredSortedSet.remove(3);
    }


    @Data
    public static class Recommend implements Serializable {

        private static final long serialVersionUID = -7712039808010061407L;
        private Integer userId;
        private double weights;
    }


    @Test
    void bucketTest() {
        RBucket<Recommend> recommend = redissonClient.getBucket("recommend", new TypedJsonJacksonCodec(Recommend.class));
        Recommend recommend1 = new Recommend();
        recommend1.setUserId(1);
        recommend1.setWeights(1.5);
        recommend.set(recommend1);

        Recommend recommend2 = recommend.get();

        System.out.println(recommend2.getUserId());


    }


    @Test
    void testIntMap() {
        String key = "simpleTestInt";
        RScoredSortedSet<Integer> scoredSortedSet = redissonClient.getScoredSortedSet(key, new TypedJsonJacksonCodec(Integer.class));
        /*scoredSortedSet.expire(180, TimeUnit.SECONDS);
        Map<Integer, Double> map = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            double boundedDouble = 0;
            if (i % 3 == 0) {
                boundedDouble = 5;
            } else if (i % 3 == 1) {
                boundedDouble = 3;
            } else {
                boundedDouble = 2.5;
            }

            map.put(i, boundedDouble);
        }

        scoredSortedSet.addAll(map);
*/
        scoredSortedSet.add(9.0, 9);
        Set<Integer> score = scoredSortedSet.readSort(key, SortOrder.DESC, 0, 5);
        int size = scoredSortedSet.size();
        scoredSortedSet.remove(1);
        System.out.println(score);
        System.out.println(size);





    }

    @Test
    void testIntMapSize() {
        String key = "simpleTestInt";
        RScoredSortedSet<Object> scoredSortedSet = redissonClient.getScoredSortedSet(key);
        System.out.println(scoredSortedSet.size());
        scoredSortedSet.delete();
    }
}
