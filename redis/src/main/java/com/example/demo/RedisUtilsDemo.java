package com.example.demo;

import redis.clients.jedis.Jedis;

/**
 * Created by lenovo on  十一月
 */
public class RedisUtilsDemo {
    public static void main(String[] args) {
        Jedis jedis=RedisUtils.getJedis();
        String name=jedis.get("name");
        System.out.println("name:"+name);

    }


}
