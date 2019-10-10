package com.hong.utils.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author: Seth
 * @Description:
 * @Date: Created in 14:58 2019/10/7
 */

public class MyRedisTemplate<K, V> extends RedisTemplate<K, V> {
    @Override
    public void setKeySerializer(RedisSerializer<?> serializer) {
        super.setKeySerializer(new StringRedisSerializer());
    }

    @Override
    public void setHashKeySerializer(RedisSerializer<?> hashKeySerializer) {
        super.setHashKeySerializer(new StringRedisSerializer());
    }
}
