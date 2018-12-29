package com.chatweb.only.service.impl;

import com.chatweb.only.mapper.TestMapper;
import com.chatweb.only.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TestServiceImpl implements ITestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public Map<String, Object> getUser(String id) {
        return testMapper.getUser(id);
    }
}
