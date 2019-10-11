package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    @RequestMapping("hello.do")
    public String showHello(ModelMap modelMap){
        System.out.println("HelloController.showHello()");
        //返回视图名
        String welcomeMessage = "欢迎使用SpringMVC框架！";
        modelMap.addAttribute("welcomeMessage",welcomeMessage);
        return "templates/hello.html";
    }


}
