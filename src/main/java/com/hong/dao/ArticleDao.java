package com.hong.dao;

import com.hong.domain.Article;
import com.hong.domain.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

/**
 * @Author: Seth
 * @Description:
 * @Date: Created in 14:46 2018/10/4
 */
public class ArticleDao {
    private JdbcTemplate jdbcTemplate;

    private final String GETALL_SQL = "SELECT * FROM `article`";

    private final String ADD_SQL = "INSERT INTO `Article`(`title`, `content`, `p_time`, `Type`) values(?, ?, NOW(), ?)";

    private final String SEARCH_SQL = "SELECT * FROM `article` WHERE `title` = ?";

    private final String DEL_SQL = "DELETE FROM `Article` WHERE `title` = ?";

    private final String DELALL_SQL = "DELETE FROM `Article`";

    private final String SEL_TYPE_SQL = "SELECT * FROM `article` WHERE `type` = ?";

    private final String SEL_ID_SQL = "SELECT * FROM `article` WHERE `id` = ?";

    private final String PREV_TIME_SQL = "SELECT * FROM `article` WHERE `p_time` = (SELECT " +
            " `p_time` FROM `article` WHERE `p_time` < ? ORDER BY `p_time` DESC LIMIT 1)";

    private final String NEXT_TIME_SQL = "SELECT * FROM `article` WHERE `p_time` = (SELECT " +
            " `p_time` FROM `article` WHERE `p_time` > ? ORDER BY `p_time` ASC LIMIT 1)";

    private final String PAGER_SQL = "SELECT * FROM `article` LIMIT ?, ?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //former
    class MyRowMapper implements RowMapper<Article> {
        @Override
        public Article mapRow(ResultSet resultSet, int i) throws SQLException {
            final Article article = new Article();
            article.setTitle(resultSet.getString("title"));
            article.setContent(resultSet.getString("content"));
            //String ymd = resultSet.getTimestamp("p_time").toString().split(" ")[0];
            //Timestamp timestamp = new Timestamp(ymd)
            article.setTimestamp(resultSet.getTimestamp("p_time"));
            article.setType(resultSet.getString("type"));
            article.setId(resultSet.getInt("id"));
            return article;
        }
    }

//    class MyLobExtractor extends AbstractLobStreamingResultSetExtractor<Article> {
//
//        @Override
//        protected void streamData(ResultSet resultSet) throws SQLException, IOException, DataAccessException {
//            InputStream inputStream = lobHandler.getBlobAsBinaryStream(resultSet, 1);
//            FileCopyUtils.copy(lobHandler.getBlobAsBinaryStream(resultSet, 1))
//        }
//    }

    /**
     * @Description:  get all the articles.
     * @param: []
     * @return: java.util.List<com.hong.domain.Article>
     * @Date: 2018/10/4 15:08
     */
    public List<Article> getAllArticles() {
        return jdbcTemplate.query(GETALL_SQL,new MyRowMapper());
    }

    /**
     * @Description:    get the article that title matched.
     * @param: [title]
     * @return: com.hong.domain.Article
     * @Date: 2018/10/4 15:26
     */
    public Article getArticle(String title) {
        return jdbcTemplate.queryForObject(SEARCH_SQL, new MyRowMapper(), title);
        //此处可用 new Object[] { title },但没必要，因为只有1个参数，无须使用数组来存储变量列表
        //Redundant array creation for calling varargs method less... (Ctrl+F1)
        //This inspection reports unnecessary creation of array expression to be passed as an argument to varargs parameter
    }

    /**
     * @Description:  delete the article that title matched.
     * @param: [title]
     * @return: int
     * @Date: 2018/10/4 15:10
     */
    public int delArticle(String title) {
        int k;
        try {
            k = jdbcTemplate.update(DEL_SQL, title);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return k;
    }

    /**
     * @Description:  add an article
     * @param: [article]
     * @return: int
     * @Date: 2018/10/4 15:38
     */
    public int addArticle(Article article) {
        Object[] args = {article.getTitle(), article.getContent(), article.getType()};
        int k;
        try {
            k = jdbcTemplate.update(ADD_SQL, args);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return k;
    }

    /**
     * @Description:  delete all the articles
     * @param: []
     * @return: int
     * @Date: 2018/10/5 7:05
     */
    @SuppressWarnings("unused")
    public int delAllArticles() {
        int k;
        try {
            k = jdbcTemplate.update(DELALL_SQL);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return k;
    }

    /**
     * @Description:  add some articles
     * @param: []
     * @return: int
     * @Date: 2018/10/5 7:18
     */
    public int addSome() {
        int k;
        Article article = new Article();
        for (int i = 0; i < 1; i++) {
            article.setId(i);
            article.setType("type");
            article.setTimestamp(new Timestamp(new Date().getTime()));
            String temp1 = "  这是帖子1.测试一下 emm";
            String format_str;
            System.out.println(temp1);
            format_str = temp1.replaceAll("\\s+", "&nbsp;").replaceAll("[\\r\\n]", "<br>");    //\r|\n
            System.out.println(temp1);
            article.setContent(format_str);
        }
        try {
            k = jdbcTemplate.update(ADD_SQL, article.getTitle(), article.getContent(), article.getType());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return k;
    }

    /**
     * @Description:  get all the articles that type matched.
     * @param: [type]
     * @return: java.util.List<com.hong.domain.Article>
     * @Date: 2018/10/6 8:04
     */
    public List<Article> getTypeArticles(Type type) {
        return jdbcTemplate.query(SEL_TYPE_SQL,new MyRowMapper(), type.getT_name());
    }

    /**
     * @Description:
     * @param: [id]
     * @return: com.hong.domain.Article
     * @Date: 2018/10/6 19:22
     */
    public Article getIdArticle(String id) {
        return jdbcTemplate.queryForObject(SEL_ID_SQL,new MyRowMapper(), id);
    }

    /**
     * @Description:
     * @param: [article]
     * @return: com.hong.domain.Article
     * @Date: 2018/10/7 7:02
     */
    public Article getPrevByTime(Article article) {
        return jdbcTemplate.queryForObject(PREV_TIME_SQL, new MyRowMapper(), article.getTimestamp());
    }

    /**
     * @Description:
     * @param: [article]
     * @return: com.hong.domain.Article
     * @Date: 2018/10/7 7:07
     */
    public Article getNextByTime(Article article) {
        return jdbcTemplate.queryForObject(NEXT_TIME_SQL, new MyRowMapper(), article.getTimestamp());
    }

    /**
     * @Description:
     * @param: [beginIndex, count]
     * @return: java.util.List<com.hong.domain.Article>
     * @Date: 2018/10/7 16:37
     */
    public List<Article> getPagerArticles(int index, int count) {  //count is the PageList.pageCount，每页显示的行数
        int beginIndex = (index - 1) * count;
        return jdbcTemplate.query(PAGER_SQL, new MyRowMapper(), beginIndex, beginIndex + count); //limit first index从0开始
    }

}
