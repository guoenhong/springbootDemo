package com.example.demo.dev1.mapper;

import com.example.demo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user_info where name = #{name}")
    User findByName(@Param("name") String name);

    @Insert("insert into user_info(name,sex) values(#{name}, #{sex})")
    int insertUser(@Param("name") String name,@Param("sex") String sex);
}
