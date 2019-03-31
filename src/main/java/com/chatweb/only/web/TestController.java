package com.chatweb.only.web;

import com.chatweb.only.bean.Result;
import com.chatweb.only.bean.ResultCode;
import com.chatweb.only.service.ITestService;
import com.chatweb.only.tableEntity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 测试接口
 *
 * @author InnerConce
 * @date 2019/01/20
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private ITestService iTestService;

    /**
     * @RequestMapping (value = {"/user/{id}","/{id}"}, method = {RequestMethod.GET,RequestMethod.POST})
     */
    @GetMapping("/user/{id}")
    @PostMapping("/{id}")
    public User getUser(@PathVariable("id") String id) {
        System.out.println("处理中");
        return iTestService.getUser(id);
    }

    @GetMapping("/result/{id}")
    public Result isResult(@PathVariable("id") String id,
                           @RequestParam(value = "rp", required = false, defaultValue = "是不是") String requestParam) {
        System.out.println("处理中");
        return new Result(ResultCode.SUCCEED, (Object) (id + requestParam));
    }

    @GetMapping("/user")
    public User cacheUser(String id) {
        User user = iTestService.getUser(id);
        return user;
    }
}
