package com.hong.domain;

import java.io.Serializable;

/**
 * @Author: Seth
 * @Description:    test Redis
 * @Date: Created in 8:58 2019/9/3
 */

public class User implements Serializable {
    private String id;
    private String name;
    private String sex;
    private String nation;
    private long register_time;

    public User() {

    }

    public User(String id, String name, String sex, String nation, long register_time) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.nation = nation;
        this.register_time = register_time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public long getRegister_time() {
        return register_time;
    }

    public void setRegister_time(long register_time) {
        this.register_time = register_time;
    }
}
