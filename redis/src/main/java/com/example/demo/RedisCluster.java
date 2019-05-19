package com.example.demo;

import org.apache.log4j.Logger;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;
import java.util.Set;

/**
 * jedis操作集群
 */
public class RedisCluster {
    private static Logger logger=Logger.getLogger(RedisCluster.class);
    public static void main(String[] args) {

        Set<HostAndPort> nodes=new HashSet<>();
        //创建多个主机和端口实例
        HostAndPort hostAndPort=new HostAndPort("192.168.213.11",7000);
        HostAndPort hostAndPort1=new HostAndPort("192.168.213.11",7001);
        HostAndPort hostAndPort2=new HostAndPort("192.168.213.11",7002);
        HostAndPort hostAndPort3=new HostAndPort("192.168.213.11",7003);
        HostAndPort hostAndPort4=new HostAndPort("192.168.213.11",7004);
        HostAndPort hostAndPort5=new HostAndPort("192.168.213.11",7005);
        //添加多个主机和端口到集合中
        nodes.add(hostAndPort);
        nodes.add(hostAndPort1);
        nodes.add(hostAndPort2);
        nodes.add(hostAndPort3);
        nodes.add(hostAndPort4);
        nodes.add(hostAndPort5);

        //创建JedisPoolConfig实例
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        //创建集群实例
        JedisCluster jedisCluster=new JedisCluster(nodes,jedisPoolConfig);

        String name= jedisCluster.get("userName");
        logger.debug("查询集群，得知key为name的对应value为："+name);

    }
}
