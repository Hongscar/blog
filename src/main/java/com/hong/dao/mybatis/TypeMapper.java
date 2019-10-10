package com.hong.dao.mybatis;

import com.hong.domain.Type;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: Seth
 * @Description:
 * @Date: Created in 20:03 2018/10/11
 */
public interface TypeMapper {

    @Select("SELECT * FROM `type`")
    List<Type> getTypes();

    @Insert("INSERT INTO `type` VALUES(#{type.t_name}, 0, #{type.desc})")
    void addType(@Param("type") Type type);

    @Update("UPDATE `type` SET `number` = `number` + 1 WHERE `t_name` = #{type.t_name}")
    void increType(@Param("type") Type type);

    @Update("UPDATE `type` SET `number` = `number` - 1 WHERE `t_name` = #{type.t_name}")
    void decreType(@Param("type") Type type);

    @Delete("DELETE FROM `type` WHERE `t_name` = #{type.t_name}")
    void delType(@Param("type") Type type);
}
