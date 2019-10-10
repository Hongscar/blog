package com.hong.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: Seth
 * @Description:
 * @Date: Created in 14:35 2018/10/4
 */
@SuppressWarnings("unused")
public class Progress implements Serializable {
    private int id;
    private Timestamp timestamp;
    private String pro_content; //varchar(50)

    public Progress() {

    }

    public Progress(int id, Timestamp timestamp, String pro_content) {
        this.id = id;
        this.timestamp = timestamp;
        this.pro_content = pro_content;
    }

    /**
     * @Description: 
     * @param: []
     * @return: int 
     * @Date: 2018/10/4 14:46
     */ 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getPro_content() {
        return pro_content;
    }

    public void setPro_content(String pro_content) {
        this.pro_content = pro_content;
    }
}
