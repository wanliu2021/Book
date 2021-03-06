package com.example.service.impl;

import com.example.entity.AuthUser;
import com.example.mapper.UserMapper;
import com.example.service.AuthService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Service
public class AuthServiceImpl implements AuthService {
    @Resource
    UserMapper mapper;


    @Transactional
    @Override
    public boolean register(String username, String sex, String grade, String password) {
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        AuthUser user=new AuthUser(0,username,encoder.encode(password),"user");
        if (mapper.registerUser(user)<=0){
            throw new  RuntimeException("用户信息插入失败");
        }
        if (mapper.addStudent(user.getId(),user.getUsername(),sex,grade)<=0){
            throw new RuntimeException("学生插入失败");
        }
        return true;
    }

    @Override
    public AuthUser findUser(HttpSession session){
        AuthUser user =(AuthUser) session.getAttribute("user");
        if (user==null){
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            user = mapper.getPasswordByUsername(authentication.getName());
            session.setAttribute("user",user);
        }
        return user;
    }
}
