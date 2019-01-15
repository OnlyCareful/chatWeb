package com.chatweb.only.web;

import com.chatweb.only.service.ITestService;
import com.chatweb.only.tableEntity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService iTestService;

    @GetMapping("/user/{id}")
    public List<User> getUser(@PathVariable("id") String id) {
        System.out.println("处理中");
        return iTestService.getUser(id);
    }

}
