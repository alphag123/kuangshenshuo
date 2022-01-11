package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//只要实现了controller接口的类，说明这就是一个控制器了
@Controller
@RequestMapping("/c3")
public class ControllerTest3{

    @RequestMapping("/t1")
    private String test1(){
        return "test";
    }

}
