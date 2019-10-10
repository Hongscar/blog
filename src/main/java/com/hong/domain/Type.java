package com.hong.domain;

import java.io.Serializable;

/**
 * @Author: Seth
 * @Description:
 * @Date: Created in 14:34 2018/10/4
 */

public class Type implements Serializable {
    private String t_name;
    private int number;
    private String desc;

    public Type() {

    }

    @SuppressWarnings("unused")
    public Type(String t_name, int number, String desc) {
        this.t_name = t_name;
        this.number = number;
        this.desc = desc;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getT_name() {
        return t_name;
    }

    public void setT_name(String t_name) {
        this.t_name = t_name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
