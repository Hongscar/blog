//package com.hong.service;
//
//import com.hong.domain.User;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.ImportResource;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import redis.clients.jedis.Jedis;
//
///**
// * @Author: Seth
// * @Description:    Configure class, create the RedisTemplate instance
// * @Date: Created in 8:34 2019/9/3
// */
//@Configuration
////@ImportResource(value = "classpath:application.properties")
//public class AppConfig {
//    private @Value("129.129.232.133") String redisHost;
//    private @Value(("6379")) int redisPort;
//
//    @Bean
//    JedisConnectionFactory jedisConnectionFactory() {
//        JedisConnectionFactory factory = new JedisConnectionFactory();
//        factory.setHostName(redisHost);
//        factory.setPort(redisPort);
//        factory.setUsePool(true);
//        return factory;
//    }
//
//    @Bean
//    RedisTemplate<String, User> redisTemplate() {
//        RedisTemplate<String, User> template = new RedisTemplate<>();
//        template.setKeySerializer(new StringRedisSerializer());
//        template.setHashKeySerializer(new StringRedisSerializer());
//        template.setHashValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
//        template.setConnectionFactory(jedisConnectionFactory());
//        return template;
//    }
//}
