package com.hong.dao.mybatis;

import com.hong.domain.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * @Author: Seth
 * @Description:
 * @Date: Created in 8:39 2018/10/11
 */
public interface ArticleMapper {
    @Select("SELECT title FROM article WHERE id = #{a_id}")
    String getSthByMapper(@Param("a_id")int id);

    Article getArticle(int t_id);


}
