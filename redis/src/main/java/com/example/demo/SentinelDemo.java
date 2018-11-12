package com.example.demo;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.nio.channels.SelectionKey;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 哨兵监控Redis
 */
public class SentinelDemo {
    private static Logger logger=Logger.getLogger(SentinelDemo.class);

    public static void main(String[] args) {
        //jedis连接连配置
        JedisPoolConfig jedisPoolConfig= new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(100);
        jedisPoolConfig.setMaxIdle(20);
        jedisPoolConfig.setMinIdle(10);

        //哨兵信息
        Set<String>  sentinelSet=new HashSet<String>(Arrays.asList( "192.168.213.11:26379","192.168.213.22:26379") )  ;
        JedisSentinelPool sentinelPool=new JedisSentinelPool("mymaster",sentinelSet,jedisPoolConfig);

        //通过哨兵连接池获取jedis客户端信息
        Jedis jedis=sentinelPool.getResource();
        jedis.set("myKey","myValue");
        logger.debug("The value of key :"+jedis.get("myKey"));
        jedis.close();
    }
}
