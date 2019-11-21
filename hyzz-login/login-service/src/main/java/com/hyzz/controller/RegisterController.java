package com.hyzz.controller;

import com.hyzz.pojo.User;
import com.hyzz.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterController {

    @Autowired
    private RegisterService registerService;
    /**
     * 注册
     * 接口:/register
     */
    @PostMapping("/register")
    public Boolean register(User user) {
        Boolean register = registerService.register(user);
        return register;
    }
}
