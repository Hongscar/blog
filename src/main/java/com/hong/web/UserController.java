//package com.hong.web;
//
//import com.hong.domain.User;
//import com.hong.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.Instant;
//
///**
// * @Author: Seth
// * @Description: test Redis
// * @Date: Created in 9:09 2019/9/3
// */
//@RestController
//@RequestMapping("/rest/user")
//public class UserController {
//    @Autowired
//    private UserService userRepository;
//
//    @RequestMapping("/{id}")
//    public User add(@PathVariable String id, @RequestParam String name, @RequestParam String sex,
//                    @RequestParam String nation) {
//        return userRepository.save(new User(id, name, sex, nation, Instant.now().getEpochSecond()));
//    }
//
//    @RequestMapping("/{id}")
//    public User findById(@PathVariable String id) {
//        return userRepository.findById(id);
//    }
//
//    @RequestMapping("/{id}")
//    public User updateUserById(@PathVariable String id, @RequestParam String name, @RequestParam String sex,
//                               @RequestParam String nation, @RequestParam long register_time) {
//        return userRepository.update(new User(id, name, sex, nation, register_time));
//    }
//
//    @RequestMapping("/{id}")
//    public void deleteUserById(@PathVariable String id) {
//        userRepository.delete(id);
//    }
//
//
//}
