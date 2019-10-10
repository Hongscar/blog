package com.hong.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: Seth
 * @Description: the domain model of the Article
 * @Date: Created in 11:41 2018/10/4
 */

public class Article implements Serializable {
    private String title;
    private String content;
    private Timestamp timestamp;    //yyyy-mm-dd hh:mm:ss
    private String type;
    private int id;

    public Article() {

    }

    public Article(int id, String title, String content, Timestamp timestamp, String type) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.timestamp = timestamp;
        this.type = type;
    }

    /**
         * @Description: 
         * @param: []
         * @return: java.lang.String 
         * @Date: 2018/10/4 14:09 
         */ 
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
