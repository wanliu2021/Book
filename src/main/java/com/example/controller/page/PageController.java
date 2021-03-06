package com.example.controller.page;

import com.example.entity.AuthUser;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class PageController {

//    @Resource
//    UserMapper mapper;
//
//    @RequestMapping("/index")
//    public String index(HttpSession session, Model model){
//        AuthUser user =(AuthUser) session.getAttribute("user");
//        if (user==null){
//            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//            user = mapper.getPasswordByUsername(authentication.getName());
//            session.setAttribute("user",user);
//        }
//        model.addAttribute("user",user);
//        return "index";
//    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}