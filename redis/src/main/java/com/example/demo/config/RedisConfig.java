package com.example.demo.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;

import java.time.Duration;


@Configuration
@EnableCaching
public class RedisConfig {
    @Value("${spring.redis.host:localhost}")
    private String host;
    @Value("${spring.redis.port:6379}")
    private int port;
    @Value("${spring.redis.timeout:30000}")
    private int timeout;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.pool.max-active:8}")
    private int maxActive;
    @Value("${spring.redis.pool.max-wait:-1}")
    private int maxWait;
    @Value("${spring.redis.pool.max-idle:8}")
    private int maxIdle;
    @Value("${spring.redis.pool.min-idle:0}")
    private int minIdle;


    /**
     * 用 @Primary 注解修饰，表示是默认的缓存管理器。
     * <p>
     * 缓存一小时。
     *
     * @return
     */
    @Bean
    @Primary
    public CacheManager cacheManagerOneHour() {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = getJackson2JsonRedisSerializer();
        JedisConnectionFactory jedisConnectionFactory = redisConnectionFactory();
        return RedisCacheManager.builder(jedisConnectionFactory)
                .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig()
                        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                        //entryTtl 表示缓存的时间. 24*60
                        .entryTtl(Duration.ofMinutes(1440)))
                .build();
    }


    /**
     * 缓存一天
     *
     * @return
     */
    @Bean
    public CacheManager cacheManagerOneDay() {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = getJackson2JsonRedisSerializer();
        JedisConnectionFactory jedisConnectionFactory = redisConnectionFactory();
        return RedisCacheManager.builder(jedisConnectionFactory)
                .cacheDefaults(RedisCacheConfiguration.defaultCacheConfig()
                        .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
                        //entryTtl 表示缓存的时间
                        .entryTtl(Duration.ofDays(1)))
                .build();
    }


    /**
     * 序列化
     *
     * @return
     */
    public Jackson2JsonRedisSerializer<Object> getJackson2JsonRedisSerializer() {
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        return jackson2JsonRedisSerializer;
    }


    /**
     * redis 连接
     *
     * @return
     */
    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPort(port);
        redisStandaloneConfiguration.setPassword(password);
//        redisStandaloneConfiguration.setDatabase();
        return new JedisConnectionFactory(redisStandaloneConfiguration);
    }

}