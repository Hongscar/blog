package com.hong.dao.mybatis;

import com.hong.domain.Article;
import com.hong.domain.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: Seth
 * @Description: it's the ArticleMapper
 * @Date: Created in 14:53 2018/10/11
 */
public interface TestMapper {
    @Select("SELECT title FROM article WHERE id = #{a_id}")
    String getSthByMapper(@Param("a_id") int id);

    @Select("SELECT * FROM `article`")
    List<Article> getAllArticles();

    @Select("SELECT * FROM `article` LIMIT 3")
    List<Article> getThreeArticles();

    @Insert("INSERT INTO `article`(`title`,`content`,`timestamp`,`Type`) " +
            "VALUES(#{article.title},#{article.content},NOW(),#{article.type})")
    int addArticle(@Param("article") Article article);

    @Update("UPDATE `type` SET `number` = `number` + 1 WHERE `t_name` = #{type}")
    void updateArticle(@Param("type")String string);

    @Select("SELECT count(*) from `article`")
    int getJava();

    @Select(("SELECT * FROM `article` WHERE `title` = #{title}"))
    Article getArticle(@Param("title") String title);

    @Delete("DELETE FROM `article` WHERE `title` = #{title}")
    int delArticle(@Param("title") String title);

    @Delete("DELETE FROM `article`")
    @SuppressWarnings("unused")
    int delAllArticles();

    @Select("SELECT * FROM `article` WHERE `type` = #{type.t_name}")
    List<Article> getArticlesByType(@Param("type") Type type);

    @Select("SELECT * FROM `article` WHERE `type` = #{type}")
    List<Article> findArticlesByType(@Param("type")String type);

    @Select("SELECT * FROM `article` WHERE `id` = #{id}")
    Article getIdArticle(@Param("id") String id);

    @Select("SELECT * FROM `article` WHERE `timestamp` = (SELECT `timestamp` FROM `article`" +
            "WHERE `timestamp` < #{article.timestamp} ORDER BY `timestamp` DESC LIMIT 1)")
    Article getPrevByTime(@Param("article") Article article);

    @Select("SELECT * FROM `article` WHERE `timestamp` = (SELECT `timestamp` FROM `article` " +
            "WHERE `timestamp` > #{article.timestamp} ORDER BY `timestamp` ASC LIMIT 1)")
    Article getNextByTime(@Param("article") Article article);

    @Select("SELECT * FROM `article` LIMIT #{beginIndex}, #{num}")
    List<Article> getPagerArticles(@Param("beginIndex") int index, @Param("num") int count);

    @Select("SELECT * FROM `article` where `title` like #{str}")
    List<Article> searchArticles(@Param("str")String string);

}
