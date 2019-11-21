package com.hyzz.service;

import com.hyzz.mapper.UserMapper;
import com.hyzz.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 登录
     * @return
     */
    public User login(String tele, String password) {
        //根据用户名查询是否有该用户
        User user = new User();
        user.setTele(tele);
        List<User> users = userMapper.select(user);
        //根据查询的用户信息来进行密码匹配
        if (users.size() >0){
            return null;
        }
        if(password.equals(users.get(0).getPassword())){
            return users.get(0);
        }
        return null;
    }
}
