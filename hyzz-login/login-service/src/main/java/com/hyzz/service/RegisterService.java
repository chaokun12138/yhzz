package com.hyzz.service;

import com.hyzz.common.enums.ExceptionEnums;
import com.hyzz.common.exception.HyzzException;
import com.hyzz.mapper.UserMapper;
import com.hyzz.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    private final  String KEY_PREFIX = "user:code:phone:";
    /**
     * 注册
     * @param user 用户注册信息
     */
    public User register(User user,String code) {
        //判断验证码是否为空
        if(code == "" || code.isEmpty()){
            return null;
        }
        //获取redis中的验证码
        String key = KEY_PREFIX + user.getTele();
        String codeCache = redisTemplate.opsForValue().get(key);
        //判断验证码是否正确
        if (!codeCache.equals(code)){
            throw new HyzzException(ExceptionEnums.CHECK_CODE_EXCEPTION);
        }
        //授权(注册用户)为完善信息的用户
        user.setRoleId(1);
        //进行注册
        int result = userMapper.insertSelective(user);
        //注册结果判断
        if (result != 0){
            return user;
        }
        return null;
    }

    /**
     * 检查手机号是否重复
     * @param phone
     */
    public void cPhone(String phone) {
        if (phone.isEmpty()){
            return;
        }
        User user = new User();
        user.setTele(phone);
        List<User> select = userMapper.select(user);
        if (!select.isEmpty()){
            throw new HyzzException(ExceptionEnums.NUMBER_ALREADY_EXISTS);
        }
    }

    /**
     * 检查邮箱是否重复
     * @param email
     */
    public void cEmail(String email) {
        if (email.isEmpty()){
            return;
        }
        User user = new User();
        user.setEmail(email);
        List<User> select = userMapper.select(user);
        if (!select.isEmpty()){
            throw new HyzzException(ExceptionEnums.EMAIL_ALREADY_EXISTS);
        }
    }
}
