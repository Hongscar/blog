package com.hong.utils.redis;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.util.StringUtils;

import java.lang.reflect.Method;

/**
 * @Author: Seth
 * @Description:
 * @Date: Created in 17:09 2019/10/7
 */

public class MyKeyGenerator implements KeyGenerator {

    @Override
    public Object generate(Object target, Method method, Object... params) {
        return target.getClass().getSimpleName() + "_" + method.getName() + "_" +
                StringUtils.arrayToDelimitedString(params, "_");
    }
}
