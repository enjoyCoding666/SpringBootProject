package com.example.demo.demo;


import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 哨兵监控Redis
 */
@Slf4j
public class SentinelDemo {

    public static void main(String[] args) {
        //jedis连接连配置
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxIdle(20);
        jedisPoolConfig.setMinIdle(10);

        //哨兵信息
        Set<String> sentinelSet = new HashSet<>(Arrays.asList("192.168.213.11:26379", "192.168.213.22:26379"));
        Jedis jedis;
        try (JedisSentinelPool sentinelPool = new JedisSentinelPool("mymaster", sentinelSet, jedisPoolConfig)) {

            //通过哨兵连接池获取jedis客户端信息
            jedis = sentinelPool.getResource();
            jedis.set("myKey", "myValue");
            log.debug("The value of key :" + jedis.get("myKey"));
            jedis.close();
        }

    }
}
