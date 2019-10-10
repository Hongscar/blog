package com.hong.dao.mybatis;

import com.hong.utils.redis.MyKeyGenerator;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * @Author: Seth
 * @Description:
 * @Date: Created in 17:19 2019/10/7
 */
@EnableCaching
//@Configuration
public class ApplicationConfig extends CachingConfigurerSupport {

//    @Override
//    @Bean
//    public CacheManager cacheManager() {
//        SimpleCacheManager cacheManager = new SimpleCacheManager();
//        Cache commonCache = new ConcurrentMapCache("common");
//        cacheManager.setCaches(Arrays.asList(commonCache));
//        return cacheManager;
//    }

    @Override
    @Bean(name = "customKeyGenerator")
    public KeyGenerator keyGenerator() {
        return new MyKeyGenerator();
    }
}
