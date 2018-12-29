package com.chatweb.only.mapper;

import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface TestMapper {

    @Select("Select * from User where id = #{id}")
    Map<String, Object> getUser(String id);
}
