package com.chatweb.only.service;

import com.chatweb.only.tableEntity.User;

import java.util.List;

public interface ITestService {

    List<User> getUser(String id);
}
