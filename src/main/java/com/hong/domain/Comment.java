package com.hong.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: Seth
 * @Description: the domain model of the Comment
 * @Date: Created in 14:29 2018/10/4
 */

public class Comment implements Serializable {
    private int id;
    private String name;
    private String mailBox;
    private String content; //varchar(100)
    private Timestamp timestamp;

    public Comment() {

    }

    @SuppressWarnings("unused")
    public Comment(int id, String name, String mailBox, String content, Timestamp timestamp) {
        this.id = id;
        this.name = name;
        this.mailBox = mailBox;
        this.content = content;
        this.timestamp = timestamp;
    }

    /**
     * @Description: 
     * @param: []
     * @return: int
     * @Date: 2018/10/4 14:34 
     */ 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMailBox() {
        return mailBox;
    }

    public void setMailBox(String mailBox) {
        this.mailBox = mailBox;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @SuppressWarnings("unused")
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
