package com.hong.dao.mybatis;

import com.hong.domain.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Seth
 * @Description:
 * @Date: Created in 19:36 2018/10/11
 */
public interface CommentMapper {

    @Select("SELECT * FROM `comment`")
    List<Comment> getComments();

    @Insert("INSERT INTO `comment`(`name`,`mailBox`,`content`,`timestamp`) " +
            "VALUES(#{comment.name}, #{comment.mailBox}, #{comment.content}, NOW())")
    void addComment(@Param("comment") Comment comment);
}
