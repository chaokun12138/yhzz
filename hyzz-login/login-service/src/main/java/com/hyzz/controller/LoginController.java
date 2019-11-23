package com.hyzz.controller;

import com.hyzz.pojo.User;
import com.hyzz.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;
    /**
     * 登录
     * 接口:/login
     */
    @PostMapping("/login")
    public ResponseEntity<User> login(String tele,String password){
        User login = loginService.login(tele,password);
        return ResponseEntity.ok(login);
    }
}
