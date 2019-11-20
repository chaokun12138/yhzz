package com.hyzz.service;

import com.github.pagehelper.PageInfo;
import com.hyzz.pojo.User;

public interface UserService {
    PageInfo<User> selectUserListByLimit(Integer pageNum, Integer size);

    User selectUserById(Integer id);

    Boolean updateUserById(User user);

    Boolean deleteUserById(Integer id);
}
