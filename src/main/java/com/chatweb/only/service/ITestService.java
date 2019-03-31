package com.chatweb.only.service;

import com.chatweb.only.tableEntity.User;

/**
 * 测试服务类
 * @author InnerConce
 * @date 2019/03/31
 */
public interface ITestService {

    /**
     * 根据ID查询用户
     * @param id
     * @return User
     */
    User getUser(String id);
}
