package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping("home.do")
    public String showHome(HttpSession session) {
        System.out.println("HomeController.showHome()");
        System.out.println("Session中的username=" + session.getAttribute("username"));
        return "home.html";
    }
}
