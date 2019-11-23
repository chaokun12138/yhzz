package com.hyzz.controller;

import com.hyzz.pojo.User;
import com.hyzz.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<User> register(User user,String code) {
        User register = registerService.register(user,code);
        return ResponseEntity.ok(register);
    }
    /**
     * 检查手机号是否重复
     * 接口：/check/phone
     */
    @GetMapping("/check/phone/{phone}")
    public ResponseEntity<Void> cPhone(@PathVariable(value = "phone")String phone){
        registerService.cPhone(phone);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    /**
     * 检查邮箱是否重复
     * 接口：/check/Email
     */
    @GetMapping("/check/email/{email}")
    public ResponseEntity<Void> cEmail(@PathVariable(value = "email")String email){
        registerService.cEmail(email);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
