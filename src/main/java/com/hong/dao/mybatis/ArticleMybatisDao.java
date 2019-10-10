package com.hong.dao.mybatis;

import com.hong.domain.Article;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @Author: Seth
 * @Description: 原本是dao, 用SqlSessionTemplate实例化Mapper接口，但后来不需要显式实例化接口了，作废
 * @Date: Created in 9:19 2018/10/11
 */

public class ArticleMybatisDao {


    private SqlSessionTemplate sqlSessionTemplate;


    public Article getArticle(int kk_id) {
        return (Article) sqlSessionTemplate.selectOne(
                "com.hong.dao.mybatis.ArticleMybatisDao.getArticle",
                kk_id
        );
    }

    public Article getArticle2(int uu_id) {
        ArticleMapper articleMapper = sqlSessionTemplate.getMapper(ArticleMapper.class);
        return articleMapper.getArticle(uu_id);
    }


}
