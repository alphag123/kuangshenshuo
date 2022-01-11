package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class HelloController {

    //localhost:8080/hello/h1
    @RequestMapping("/h1")
    private String hello(Model model){
        //封装数据
        model.addAttribute("msg","hello,springmvcannotation");

        return "hello";//会被视图解析器处理
    }


}
