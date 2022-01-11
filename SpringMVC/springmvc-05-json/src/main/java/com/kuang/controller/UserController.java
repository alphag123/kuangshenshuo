package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/j1")
    @ResponseBody//它就不会走视图解析器，会直接返回一个字符串
    public String json1(){

        //创建一个对象
        User user = new User("秦将1号",3,"男");

        return  user.toString();
    }

}
