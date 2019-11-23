package com.hyzz.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hyzz.mapper.UserLockMapper;
import com.hyzz.mapper.UserMapper;
import com.hyzz.pojo.User;
import com.hyzz.pojo.UserLock;
import com.hyzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserLockMapper userLockMapper;
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
        return userMapper.updateByPrimaryKeySelective(user)>0;
    }

    @Override
    public Boolean deleteUserById(Integer id) {
        return userMapper.deleteByPrimaryKey(id)>0;
    }

    /**
     * 通过type的值判断keys的类型
     * type=1: 用户名
     * type=2: 电话
     * type=其他: 真实姓名或者昵称
     * @param keys 关键词
     * @param type 关键词的类型
     * @return User对象
     */
    @Override
    public User selectUserByKeys(String keys, Integer type) {
        Example example = new Example(User.class);
        switch (type){
            case 1:
                example.createCriteria().andEqualTo("name",keys );
                break;
            case 2:
                example.createCriteria().andEqualTo("tele",keys );
                break;
            default:
                return userMapper.selectUserByUsernameOrIdCard(keys);
        }
        return userMapper.selectOneByExample(example);
    }

    /**
     * 事务方法,锁定用户的同时,添加锁定时间及锁定时长以及投诉次数限制到user_lock表中
     * @param user
     * @param complainCount
     * @param lockDuration
     * @return
     */
    @Override
    @Transactional
    public Boolean lockUserById(User user, Integer complainCount, Integer lockDuration) {

        userMapper.updateByPrimaryKeySelective(user);

        UserLock userLock = new UserLock();
        userLock.setUserId(user.getId());
        userLock.setComplainCount(complainCount);
        userLock.setLockDuration(lockDuration);
        return userLockMapper.insertSelective(userLock)>0;

    }

    /**
     * 事务方法,解锁用户的同时,删除时长表的数据
     * @param user
     * @return
     */
    @Override
    @Transactional
    public Boolean unlockUserById(User user) {
        userMapper.updateByPrimaryKeySelective(user);
        return userLockMapper.deleteByPrimaryKey(user.getId())>0;
    }

    @Override
    public Boolean checkUserIsLockById(Integer id) {
        Example example = new Example(UserLock.class);
        example.createCriteria().andEqualTo("userId", id);
        //先查询此用户是否在锁定表中有记录
        UserLock result = userLockMapper.selectOneByExample(example);
        if (result!= null){
            double d =  (new Date().getTime() - result.getLockTime().getTime())/3600000.0;
            //查到记录,判断锁定时间是否结束
            if (d>=result.getLockDuration()){
                User user = new User();
                user.setIsLock(Byte.parseByte("0"));
                user.setId(id);
                //时间到,已解锁
                return unlockUserById(user);
            }
            //时间没到,用户仍然锁定状态
            return false;
        }
        //锁定表不存在此用户,此用户是信用良好状态
        return true;
    }

    /**
     * 更改User用户状态的属性:如is_ban,is_member等
     * @param statusName 要更改的字段名
     * @param status 字段的值 1:true 0:false
     * @param id 用户id
     * @return 更改用户状态成功则返回true
     */
    @Override
    public Boolean changeUserStatusById(String statusName,Integer status,Integer id) {
        return userMapper.changeUserStatusById(statusName,status,id)>0;
    }
}
