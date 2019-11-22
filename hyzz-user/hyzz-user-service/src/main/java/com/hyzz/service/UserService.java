package com.hyzz.service;

import com.github.pagehelper.PageInfo;
import com.hyzz.pojo.User;

public interface UserService {
    PageInfo<User> selectUserListByLimit(Integer pageNum, Integer size);

    User selectUserById(Integer id);

    Boolean updateUserById(User user);

    Boolean deleteUserById(Integer id);

    User selectUserByKeys(String keys, Integer type);

    Boolean lockUserById(User user, Integer complainCount, Integer lockTime);

    Boolean unlockUserById(User user);

    Boolean checkUserIsLockById(Integer id);

    /**
     * 更改User用户状态的属性:如is_ban,is_member等
     * @param statusName 要更改的字段名
     * @param status 字段的值 1:true 0:false
     * @param id 用户id
     * @return 更改用户状态成功则返回true
     */
    Boolean changeUserStatusById(String statusName,Integer status,Integer id);
}
