package com.chatweb.only.service.impl;

import com.chatweb.only.mapper.TestMapper;
import com.chatweb.only.service.ITestService;
import com.chatweb.only.tableEntity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<User> getUser(String id) {
        return testMapper.getUser(id);
    }
}
