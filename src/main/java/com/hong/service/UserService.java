//package com.hong.service;
//
//import com.hong.domain.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.HashOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
//import javax.annotation.PostConstruct;
//
///**
// * @Author: Seth
// * @Description:    test Redis
// * @Date: Created in 9:03 2019/9/3
// */
//public class UserService {
//    private static final String USERKEY = "user";
//    private HashOperations<String, Object, Object> operations;
//
//    @Autowired
//    private RedisTemplate<String, User> redisTemplate;
//
//    @PostConstruct
//    public void initOperations() {
//        this.operations = redisTemplate.opsForHash();
//    }
//
//    public User save(User user) {
//        this.operations.put(USERKEY, user.getId(), user);
//        return user;
//    }
//
//    public User findById(String id) {
//        return (User)this.operations.get(USERKEY, id);
//    }
//
//    public User update(User user) {
//        save(user);
//        return user;
//    }
//
//    public void delete(String id) {
//        this.operations.delete(USERKEY, id);
//    }
//}
