package com.chatweb.only.service.impl;

import com.chatweb.only.mapper.TestMapper;
import com.chatweb.only.service.ITestService;
import com.chatweb.only.tableEntity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 测试服务实现类
 * @author InnerConce
 * @date 2019/03/31
 */
@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    @Cacheable(value = "User")
    public User getUser(String id) {
        System.out.println("缓存方法被执行了");
        return testMapper.getUser(id);
    }
}
