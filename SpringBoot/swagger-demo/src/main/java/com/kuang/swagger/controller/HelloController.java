package com.kuang.swagger.controller;

import com.kuang.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }

    //只要我们的接口中，返回值存在实体类，他就会被扫描到swagger中
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }

    //operation接口,不是放在类上，是方法上
    @ApiOperation("hello控制类")
    @GetMapping("/hello2")
    public String hello2(@ApiParam("用户名") String username){
        return "hello"+username;
    }

    @ApiOperation("post测试类")
    @PostMapping("/postt")
    public User hello2(@ApiParam("用户名") User user){
        return user;
    }

}
