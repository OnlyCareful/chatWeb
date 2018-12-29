package com.chatweb.only.controller;

import com.chatweb.only.service.ITestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {

    @Autowired
    private ITestService iTestService;

    @GetMapping("/user/{id}")
    public Map<String,Object> getUser(@PathVariable("id") String id){
        return iTestService.getUser(id);
    }
}
