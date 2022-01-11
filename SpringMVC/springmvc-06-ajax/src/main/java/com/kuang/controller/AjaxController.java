package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AjaxController {

    @RequestMapping("/t1")
    public String test(){
        return "hello";
    }

}
