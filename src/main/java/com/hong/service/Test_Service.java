package com.hong.service;

import com.hong.dao.mybatis.CommentMapper;
import com.hong.dao.mybatis.TestMapper;
import com.hong.dao.mybatis.TypeMapper;
import com.hong.domain.Article;
import com.hong.domain.Comment;
import com.hong.domain.Type;
import com.hong.utils.redis.MyKeyGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
// import springfox.documentation.annotations.Cacheable;

import java.util.List;

/**
 * @Author: Seth
 * @Description: the function is the same as MyService,but use the MyBatis
 * @Date: Created in 14:56 2018/10/11
 */
@Service("test_service")
@Cacheable(value = "common", keyGenerator = "customKeyGenerator")
public class Test_Service {
    /**
     * @Description:
     * @param:
     * @return:
     * @Date: 2018/10/11 16:48
     */
    @Autowired
    private TestMapper testMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private TypeMapper typeMapper;


    public String doSomeBusiness(int id) {
        return this.testMapper.getSthByMapper(id);
    }

//  @CacheEvict(value = "common")   // 删除缓存
    public List<Article> getAllArticles() {
        return testMapper.getAllArticles();
    }

    public List<Article> getThreeArticles() {
        return testMapper.getThreeArticles();
    }

    public void addArticle(Article article) {
        testMapper.addArticle(article);
    }

    public void updateTypeNum(String str) {
        testMapper.updateArticle(str);
    }

    public int getJava() {
        int i = testMapper.getJava();
        System.out.println("THE NUMBER IS : " + i);
        return i;
    }

    public Article getArticle(String title) {
        return testMapper.getArticle(title);
    }

    public int delArticle(String title) {
        return testMapper.delArticle(title);
    }

    public List<Article> getTypeArticles(Type type) {
        return testMapper.getArticlesByType(type);
    }

    public List<Article> findArticlesByType(String type) {
        return testMapper.findArticlesByType(type);
    }

    public Article getIdArticle(String id) {
        return testMapper.getIdArticle(id);
    }

    public Article getPrevByTime(Article article) {
        Article article1 =  testMapper.getPrevByTime(article);
        if (article1.getTitle() == "")  //如果为空，article1为null，触发nullpointer此时post方法error，调用Ajax的error回调
            return article;
        else
            return article1;
    }

    public Article getNextByTime(Article article) {
        Article article1 = testMapper.getNextByTime(article);
        if (article1.getTitle() == "")
            return article;
        else
            return article1;
    }

    public List<Article> getPagerArticles(int index, int count) {
        int beginInd = index - 1;
        beginInd *= count;
        return testMapper.getPagerArticles(beginInd, count);
    }

    public List<Article> getPagerBean(int index, int count) {
        int beginInd = index - 1;
        beginInd *= count;
        return testMapper.getPagerArticles(beginInd, count);
    }

    public List<Comment> getAllComments() {
        return commentMapper.getComments();
    }

    public void addComment(Comment comment) {
        commentMapper.addComment(comment);
    }

    public List<Type> getTypes() {
        return typeMapper.getTypes();
    }

    public void addType(Type type) {
        typeMapper.addType(type);
    }

    public void increType(Type type) {
        typeMapper.increType(type);
    }

    public void decreType(Type type) {
        if (type.getNumber() > 1)
            typeMapper.decreType(type);
        else
            typeMapper.delType(type);   //type.number = 1,delete it.
    }

    public List<Article> searchArticles(String str) {
        String temp;
        if (str == null)
            temp = "%%";
        else
            temp = "%" + str + "%";
        return testMapper.searchArticles(temp);
    }




}
