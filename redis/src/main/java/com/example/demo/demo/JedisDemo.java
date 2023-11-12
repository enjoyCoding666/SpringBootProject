package com.example.demo.demo;

import redis.clients.jedis.Jedis;

import java.util.Iterator;
import java.util.Set;

/**
 * 使用jedis连接并查询
 */
public class JedisDemo {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 6379;
        Set<String> keys;
        try (Jedis jedis = new Jedis(host, port)) {
            String name = jedis.get("userName");
            System.out.println("userName:" + name);

            System.out.println("数据库中所有key如下：");
            keys = jedis.keys("*");
        }
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            System.out.println(key);
        }

    }
}
