package com.chatweb.only.mapper;

import com.chatweb.only.tableEntity.User;
import org.apache.ibatis.annotations.Select;

/**
 * 测试Mapper 接口
 * @author InnerConce
 * @date 2019/03/31
 */
public interface TestMapper {

    /**
     * 根据ID查询用户
     * @param id ID
     * @return User
     */
    @Select("Select * From User Where id = #{id}")
    User getUser(String id);
}
