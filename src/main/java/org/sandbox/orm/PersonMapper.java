package org.sandbox.orm;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface PersonMapper {
    int countByExample(PersonExample example);

    int deleteByExample(PersonExample example);

    @Delete({
            "delete from person",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into person (name, age, ",
            "country)",
            "values (#{name,jdbcType=VARCHAR}, #{age,jdbcType=INTEGER}, ",
            "#{country,jdbcType=VARCHAR})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(Person record);

    int insertSelective(Person record);

    List<Person> selectByExample(PersonExample example);

    @Select({
            "select",
            "id, name, age, country",
            "from person",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @ResultMap("BaseResultMap")
    Person selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByExample(@Param("record") Person record, @Param("example") PersonExample example);

    int updateByPrimaryKeySelective(Person record);

    @Update({
            "update person",
            "set name = #{name,jdbcType=VARCHAR},",
            "age = #{age,jdbcType=INTEGER},",
            "country = #{country,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Person record);
}