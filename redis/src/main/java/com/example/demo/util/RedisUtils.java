package com.example.demo.util;

/**
 * Created by lenovo on  十一月
 */
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis通过连接池连接。
 */
public class RedisUtils {

    private RedisUtils() {}

    private static JedisPool jedisPool = null;

    //通过单例模式获取链接
    public static synchronized Jedis getJedis() {
        if(jedisPool == null){
            //创建config
            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            //控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
            jedisPoolConfig.setMaxIdle(10);
            //控制一个pool最多有多少个jedis实例。
            jedisPoolConfig.setMaxTotal(100);
            //表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
            jedisPoolConfig.setMaxWaitMillis(2000);
            //在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
            jedisPoolConfig.setTestOnBorrow(true);
            jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1",6379);
        }
        //返回连接池资源
        return jedisPool.getResource();
    }

    public static void returnResource(Jedis jedis) {
        jedis.close();

    }

}
