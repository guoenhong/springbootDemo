package com.example.demo.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("select * from user_info where name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("insert into user_info(name,sex) values(#{name}, #{sex})")
    int insertUser(@Param("name") String name,@Param("sex") String sex);
}
