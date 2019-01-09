package com.chatweb.only.web;

import com.chatweb.only.service.ITestService;
import com.chatweb.only.tableEntity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private ITestService iTestService;

    @GetMapping("/user/{id}")
    public List<User> getUser(@PathVariable("id") String id) throws SQLException {
        if ("0".equals(id)){
            throw new SQLException("sql错误");
        }
        if ("1".equals(id)){
            User u = new User();
            u.setId("rwerwewerwere");
            List l = new ArrayList();
            l.add(u);
            return l;
        }
        return iTestService.getUser(id);
    }
}
