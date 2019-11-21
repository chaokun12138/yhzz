package com.hyzz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyzz.mapper.UserMapper;
import com.hyzz.pojo.User;
import com.hyzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> selectUserListByLimit(Integer pageNum, Integer size) {
        PageHelper.startPage(pageNum, size);
        List<User> userList = userMapper.selectAll();
        PageInfo<User> info = new PageInfo<>(userList);
        info.setList(userList);
        return info;
    }

    @Override
    public User selectUserById(Integer id) {
        User user = new User();
        user.setId(id);
        return userMapper.selectOne(user);
    }

    @Override
    public Boolean updateUserById(User user) {
        return userMapper.updateByPrimaryKey(user)>0;
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return userMapper.deleteByPrimaryKey(id)>0;
    }
}
