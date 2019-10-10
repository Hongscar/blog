package com.hong.dao;

import com.hong.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: Seth
 * @Description:
 * @Date: Created in 15:54 2018/10/4
 */
public class CommentDao {
    private JdbcTemplate jdbcTemplate;

    private final String GET_SQL = "SELECT * FROM `comment`";

    private final String ADD_SQL = "INSERT INTO `comment`(`name`, `mailBox`, `content`, `c_time`) values(?, ?, ?, NOW())";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * @Description:
     * @param:
     * @return:
     * @Date: 2018/10/4 16:23
     */
    class MyRowMapper implements RowMapper<Comment> {
        @Override
        public Comment mapRow(ResultSet resultSet, int i) throws SQLException {
            final Comment comment = new Comment();
            comment.setId(resultSet.getInt("id"));
            comment.setName(resultSet.getString("name"));
            comment.setMailBox(resultSet.getString("mailBox"));
            comment.setContent(resultSet.getString("content"));
            comment.setTimestamp(resultSet.getTimestamp("c_time"));
            return comment;
        }
    }

    /**
     * @Description:
     * @param: []
     * @return: java.util.List<com.hong.domain.Comment>
     * @Date: 2018/10/5 15:53
     */
    public List<Comment> getComments() {
        return jdbcTemplate.query(GET_SQL, new MyRowMapper());
    }

    /**
     * @Description:
     * @param: [comment]
     * @return: int
     * @Date: 2018/10/5 16:21
     */
    public int addComment(Comment comment) {
        Object[] args = {comment.getName(), comment.getMailBox(), comment.getContent()};
        int k;
        try {
            k = jdbcTemplate.update(ADD_SQL, args);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return k;
    }
}
