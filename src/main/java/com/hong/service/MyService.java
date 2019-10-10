package com.hong.service;

import com.hong.dao.ArticleDao;
import com.hong.dao.CommentDao;
import com.hong.dao.TypeDao;
import com.hong.domain.Article;
import com.hong.domain.Comment;
import com.hong.domain.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Seth
 * @Description:
 * @Date: Created in 15:39 2018/10/4
 */


public class MyService {
    private ArticleDao articleDao;

    private CommentDao commentDao;

    private TypeDao typeDao;

    @Autowired
    public void setArticleDao(ArticleDao articleDao) {
        this.articleDao = articleDao;
    }

    @Autowired
    public void setCommentDao(CommentDao commentDao) {
        this.commentDao = commentDao;
    }

    @Autowired
    public void setTypeDao(TypeDao typeDao) {
        this.typeDao = typeDao;
    }

    /**
     * @Description:
     * @param: [article]
     * @return: boolean
     * @Date: 2018/10/4 15:40
     */
    public void addArticle(Article article) {
        articleDao.addArticle(article);
    }

    /**
     * @Description:
     * @param: [title]
     * @return: boolean
     * @Date: 2018/10/4 15:42
     */
    @SuppressWarnings("unused")
    public void delArticle(String title) {
        articleDao.delArticle(title);
    }

    /**
     * @Description:
     * @param: []
     * @return: java.util.List<com.hong.domain.Article>
     * @Date: 2018/10/4 15:43
     */
    public List<Article> getAllArticles() {
        return articleDao.getAllArticles();
    }

    /**
     * @Description:
     * @param: [title]
     * @return: com.hong.domain.Article
     * @Date: 2018/10/4 15:44
     */
    @SuppressWarnings("unused")
    public Article getArticle(String title) {
        return articleDao.getArticle(title);
    }

    /**
     * @Description:
     * @param: []
     * @return: boolean
     * @Date: 2018/10/5 14:57
     */
    @SuppressWarnings("unused")
    public boolean addSome() {
        int flag = articleDao.addSome();
        return flag >= 1;
    }

    /**
     * @Description:
     * @param: [comment]
     * @return: boolean
     * @Date: 2018/10/5 16:24
     */
    public void addComment(Comment comment) {
        commentDao.addComment(comment);
    }

    /**
     * @Description:
     * @param: []
     * @return: java.util.List<com.hong.domain.Comment>
     * @Date: 2018/10/5 17:01
     */
    public List<Comment> getAllComments() {
        return commentDao.getComments();
    }

    /**
     * @Description:
     * @param: []
     * @return: java.util.List<com.hong.domain.Type>
     * @Date: 2018/10/5 20:43
     */
    public List<Type> getTypes() {
        return typeDao.getTypes();
    }

    /**
     * @Description:
     * @param: [type]
     * @return: boolean
     * @Date: 2018/10/5 20:44
     */
    @SuppressWarnings("unused")
    public boolean addType(Type type) {
        int flag = typeDao.addType(type);
        return flag >= 1;
    }

    /**
     * @Description:
     * @param: [type]
     * @return: boolean
     * @Date: 2018/10/5 20:45
     */
    @SuppressWarnings("unused")
    public boolean increType(Type type) {
        int flag =typeDao.increType(type);
        return flag >= 1;
    }

    /**
     * @Description:
     * @param: [type]
     * @return: boolean
     * @Date: 2018/10/5 20:45
     */
    @SuppressWarnings("unused")
    public boolean decreType(Type type) {
        int flag = typeDao.decreType(type);
        return flag >= 1;
    }

    /**
     * @Description:
     * @param: [type]
     * @return: java.util.List<com.hong.domain.Article>
     * @Date: 2018/10/6 8:05
     */
    public List<Article> getTypeArticles(Type type) {
        return articleDao.getTypeArticles(type);
    }

    /**
     * @Description:
     * @param: [id]
     * @return: com.hong.domain.Article
     * @Date: 2018/10/6 19:23
     */
    public Article getIdArticle(String id) {
        return articleDao.getIdArticle(id);
    }

    /**
     * @Description:
     * @param: [article]
     * @return: com.hong.domain.Article
     * @Date: 2018/10/7 7:08
     */
    public Article getPrevByTime(Article article) {
        return articleDao.getPrevByTime(article);
    }

    /**
     * @Description:
     * @param: [article]
     * @return: com.hong.domain.Article
     * @Date: 2018/10/7 7:09
     */
    public Article getNextByTime(Article article) {
        return articleDao.getNextByTime(article);
    }

    /**
     * @Description:
     * @param: [index, count]
     * @return: java.util.List<com.hong.domain.Article>
     * @Date: 2018/10/7 16:39
     */
    public List<Article> getPagerArticles(int index, int count) {
        return articleDao.getPagerArticles(index, count);
    }

    public static void main(String[] args) {
        System.getProperties().list(System.out);
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("java.library.path"));
    }
}
