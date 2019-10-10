package com.hong.utils.redis;


import com.hong.domain.Article;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.io.*;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Seth
 * @Description: 自定义的一个RedisUtil工具类，通过注入该类，直接操作Redis
 * @Date: Created in 12:49 2019/9/3
 */

public final class RedisUtil implements Cache{
//    private Logger logger = Logger.getLogger(RedisUtil.class);

    @Autowired
    private RedisTemplate<Serializable, Object> redisTemplate;
    private String name;

    public RedisTemplate<Serializable, Object> getRedisTemplate() {
        return redisTemplate;
    }

    public void setRedisTemplate(RedisTemplate<Serializable, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    // 序列化
    public byte[] toByteArray(Object obj) {
        byte[] bytes = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.flush();
            bytes = bos.toByteArray();
            oos.close();
            bos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bytes;
    }

    // 反序列
    public Object toObject(byte[] bytes) {
        Object obj = null;
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bis);
            obj = ois.readObject();
            ois.close();
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

    @Override
    public Object getNativeCache() {
        return this.redisTemplate;
    }

    @Override
    public ValueWrapper get(Object key) {
        System.out.println("------------------------ get key ------------------------");
        final String keyf = key.toString();
        Object obj = null;
        obj = redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] key = keyf.getBytes();
                byte[] value = connection.get(key);
                if (value == null) {
                    return null;
                }
                return toObject(value);
            }
        });
        return (obj != null ? new SimpleValueWrapper(obj) : null);
    }

    @Override
    public void put(Object key, Object value) {
        System.out.println("----------------------- put key ----------------------------");
        final String keyf = key.toString();
        final Object valuef = value;
        final long liveTime = 86400;
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] keyb = keyf.getBytes();
                byte[] valueb = toByteArray(valuef);
                connection.set(keyb, valueb);
                if (liveTime > 0)
                    connection.expire(keyb, liveTime);
                return 1L;
            }
        });
    }

    @Override
    public void evict(Object key) {
        System.out.println("------------------------- del key --------------------------");
        final String keyf = key.toString();
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.del(keyf.getBytes());
            }
        });
    }

    @Override
    public void clear() {
        System.out.println("---------------------- clear key ------------------------");
        redisTemplate.execute(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return "OK";
            }
        });
    }

//    public Article getter(String id) {
//        return (Article)get(id);
//    }
//
//    public void remove(final String... keys) {
//        for (String key: keys)
//            remove(key);
//    }
//
//    public void remove(final String key) {
//        if (exists(key))
//            redisTemplate.delete(key);
//    }
//
//    public boolean exists(final String key) {
//        return redisTemplate.hasKey(key);
//    }

//    public Object get(final String key) {
////        Object result = null;
////        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
////        result = operations.get(key);
////        return result;
//        return null;
//    }
//
//    public boolean set(final String key, Object value) {
//        boolean result = false;
//        try {
//            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
//            operations.set(key, value);
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

//    public boolean set(final String key, Object value, Long expireTime) {
//        boolean result = false;
//        try {
//            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
//            operations.set(key, value);
//            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
//            result = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return result;
//    }



    @Override
    public <T> T get(Object key, Class<T> type) {
        return null;
    }

//    @Override
//    public <T> T get(Object key, Callable<T> valueLoader) {
//        return null;
//    }



    @Override
    public ValueWrapper putIfAbsent(Object key, Object value) {
        return null;
    }




}
