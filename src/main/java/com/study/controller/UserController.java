package com.study.controller;

import com.study.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("user")
public class UserController {

    @RequestMapping(value= {"reg.do", "register.do"})
    public String showReg() {
        System.out.println("UserController.showReg()");
        return "reg.html";
    }

    @RequestMapping("login.do")
    public String showLogin() {
        System.out.println("UserController.showLogin()");
        return "login.html";
    }

    @RequestMapping("handle_reg.do")
    public String handleReg(User user, ModelMap modelMap){
        // 判断用户名是否被是"admin"(已经占用)
        if ("admin".equals(user.getUsername())){
            modelMap.addAttribute("errorMessage","注册失败！用户名已经被占用！");
            return "error.jsp";
        }
        return "redirect:login.do";
    }

    @RequestMapping(path="handle_login.do", method= {RequestMethod.POST, RequestMethod.GET})
    public String handleLogin(@RequestParam("username") String username, @RequestParam("password") String password, ModelMap modelMap, HttpSession session) {
        if ("root".equals(username)) {
            // 是：判断密码是否正确
            if ("1234".equals(password)) {
                // 是：登录成功，去主页
                session.setAttribute("username", username);
                // 当前位置：项目名/user/handle_login.do
                // 目标位置：项目名/home.do
                return "redirect:home.do";
            } else {
                // 否：使用专门的页面提示：密码错误
                modelMap.addAttribute("errorMessage", "登录失败！密码错误！");
                return "error.jsp";
            }
        } else  {
            // 否：使用专门的页面提示：用户名错误
            modelMap.addAttribute("errorMessage", "登录失败！用户名错误！");
            return "error.jsp";
        }
    }


}
