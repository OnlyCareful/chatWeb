package com.chatweb.only.mapper;

import com.chatweb.only.tableEntity.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TestMapper {

    @Select("Select * From User Where id = #{id}")
    List<User> getUser(String id);
}
