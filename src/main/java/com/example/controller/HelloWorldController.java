package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * author: alan.peng
 * description:
 * date: create in 16:21 2018/2/6
 * modified By：
 */
@Controller
public class HelloWorldController {

    //@RequestMapping("/index")
    //public String index() {
    //    return "index";
    //}

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
