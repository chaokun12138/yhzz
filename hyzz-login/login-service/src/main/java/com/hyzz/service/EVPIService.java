package com.hyzz.service;

import com.hyzz.mapper.UserMapper;
import com.hyzz.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EVPIService {

    @Autowired
    private UserMapper userMapper;
    /**
     * 完善信息
     * @param user
     */
    public User evpi(User user) {
        //数据插入
        int result = userMapper.insertSelective(user);
        //数据提交结果
        if (result == 0){
            return user;
        }
        return null;
    }
}
