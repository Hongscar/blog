package com.hong.dao;

import com.hong.domain.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Seth
 * @Description:
 * @Date: Created in 20:15 2018/10/5
 */
public class TypeDao {
    private JdbcTemplate jdbcTemplate;

    private final String GET_SQL = "SELECT * FROM `type`";

    private final String ADD_SQL = "INSERT INTO `type` VALUES(?, 1)";

    private final String INCRE_SQL = "UPDATE `type` SET `number` = `number` + 1 WHERE `t_name` = ?";

    private final String DECRE_SQL = "UPDATE `type` SET `number` = `number` - 1 WHERE `t_name` = ?";

    private final String DEL_SQL = "DELETE FROM `type` WHERE `t_name` = ?";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * @Description:
     * @param: []
     * @return: java.util.List<com.hong.domain.Type>
     * @Date: 2018/10/5 20:21
     */
    public List<Type> getTypes() {
        return jdbcTemplate.query(GET_SQL, (resultSet, i) -> {
            final Type type = new Type();
            type.setNumber(resultSet.getInt("number"));
            type.setT_name(resultSet.getString("t_name"));
            return type;
        });
    }

    /**
     * @Description:
     * @param: [type]
     * @return: int
     * @Date: 2018/10/5 20:25
     */
    public int addType(Type type) {
        Object[] args = {type.getT_name()};
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
     * @Description:  let the number of this type add one.
     * @param: [type]
     * @return: int
     * @Date: 2018/10/5 20:33
     */
    public int increType(Type type) {
        int k;
        try {
            k = jdbcTemplate.update(INCRE_SQL, type.getT_name());
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return k;
    }

    /**
     * @Description:  let the number of this type reduce one,or delete it directly.
     * @param: [type]
     * @return: int
     * @Date: 2018/10/5 20:39
     */
    public int decreType(Type type) {
        int k;
        try {
            if (type.getNumber() == 1) { //the last article,so delete this type
                k = jdbcTemplate.update(DEL_SQL, type.getT_name());
            } else {
                k = jdbcTemplate.update(DECRE_SQL, type.getT_name());
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return k;
    }
}
