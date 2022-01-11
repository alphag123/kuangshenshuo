package com.kuang.controller;

//只要实现了controller接口的类，说明这就是一个控制器了

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller//代表这个类会被spring托管
public class ControllerTest2 {

    @RequestMapping("/t2")
    public String test1(Model model){
        model.addAttribute("msg","ControllerTest2");
        return "test";
    }

    @RequestMapping("/t3")
    public String test3(Model model){
        model.addAttribute("msg","ControllerTest3");
        return "test";
    }

}
