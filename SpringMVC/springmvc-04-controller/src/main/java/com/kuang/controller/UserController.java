package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    //localhost:8080/user/t1?name=xxx;
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        //1.接收前端参数
        System.out.println("接收到前端的参数为："+name);
        //2.将返回的结果传递给前端
        model.addAttribute("msg",name);
        //3.视图跳转
        return "test";
    }

    /*
    1.接收前端用户传递的参数，判断参数的名字，假设名字直接在方法上，可以直接使用
    2.假设传递的是一个对象User,匹配User对象中的字段名：如果名字一致则欧克，否则匹配不到
     */
    //前端接收的是一个对象：id,name,age
    @GetMapping("/t2")
    public String test2(User user){
        System.out.println(user);
        return "test";
    }

    @GetMapping("/t3")
    public String test3(ModelMap map){

        return "test";
    }
}
