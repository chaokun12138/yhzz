package com.hyzz.service;

import com.hyzz.mapper.UserMapper;
import com.hyzz.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private UserMapper userMapper;

    /**
     * 注册
     * @param user 用户注册信息
     */
    public Boolean register(User user) {
        //授权(注册用户)为完善信息的用户

         return userMapper.insertSelective(user) != 0;
    }
}
