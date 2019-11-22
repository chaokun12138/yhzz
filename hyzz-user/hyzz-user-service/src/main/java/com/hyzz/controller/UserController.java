package com.hyzz.controller;

import com.github.pagehelper.PageInfo;
import com.hyzz.pojo.User;
import com.hyzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public ModelAndView tologin(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /**
     * 分页查询用户列表
     * @param pageNum 页码
     * @param size 每页条数
     * @return
     */
    @GetMapping("/list")
    public PageInfo<User> getUserListByLimit(@RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum, @RequestParam(value = "size",defaultValue = "10") Integer size){
        PageInfo<User> userListInfo = userService.selectUserListByLimit(pageNum,size);
        for (User user : userListInfo.getList()) {
            System.out.println(user);
        }
        if (CollectionUtils.isEmpty(userListInfo.getList())) {
            throw new RuntimeException("用户列表为空");
        }
        return userListInfo;
    }


    /**
     * 根据id查询单个用户详细信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public User getUserById(@PathVariable(value = "id")Integer id){
        User user = userService.selectUserById(id);
        System.out.println(user);
        if (user == null) {
            throw new RuntimeException("未查到此用户");
        }
        return user;
    }

    /**
     * 根据关键词类型查询用户
     * @param keys
     * @param type
     * @return
     */
    @GetMapping("/{keys}/{type}")
    public User getUserByKeys(@PathVariable(value = "keys")String keys,@PathVariable(value = "type")Integer type){
        User user = userService.selectUserByKeys(keys,type);
        if (user == null) {
            throw new RuntimeException("未查到此用户");
        }
        return user;
    }

    /**
     * 通过id修改用户信息,其他参数要与User类的属性一致
     * @param user
     * @param id
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateUserById(User user,@PathVariable(value = "id")Integer id){
        user.setId(id);
        Boolean b = userService.updateUserById(user);
        return ResponseEntity.ok(b);
    }

    /**
     * 通过id删除用户,返回boolean值
     * @param id
     * @return
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUserById(@PathVariable(value = "id")Integer id){
        Boolean b = userService.deleteUserById(id);
        return ResponseEntity.ok(b);
    }

    /**
     * 对用户进行屏蔽(限制投诉次数,不能发帖,查看信息受限)
     * @param id
     * @param complainCount 投诉次数限制
     * @param lockDuration 屏蔽时间(小时)
     * @return
     */
    @PutMapping("/lock/{id}")
    public ResponseEntity<Boolean> lockUserById(@PathVariable(value = "id") Integer id, Integer complainCount, Integer lockDuration){
        if (complainCount == null)
            complainCount = 5;
        if (lockDuration == null)
            lockDuration = 1;
        User user = new User();
        user.setIsLock(1);
        user.setId(id);
        return ResponseEntity.ok(userService.lockUserById(user,complainCount,lockDuration));
    }

    /**
     * 应具有管理员权限时可访问
     * 调用此接口直接解锁用户
     * @param id
     * @return
     */
    @PutMapping("/unlock/{id}")
    public ResponseEntity<Boolean> unlockUserById(@PathVariable(value = "id") Integer id){
        User user = new User();
        user.setIsLock(Byte.parseByte("0"));
        user.setId(id);
        return ResponseEntity.ok(userService.unlockUserById(user));
    }

    /**
     * 可访问此接口无需权限(页面刷新时ajax访问)
     * 检查锁定时长,若时间到期则解除锁定
     * @param id
     * @return
     */
    @PutMapping("/timeoutUnlock/{id}")
    public ResponseEntity<Boolean> timeoutUnlockUserById(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok(userService.checkUserIsLockById(id));
    }

    /**
     * 通过id封禁用户
     * @param id
     * @return
     */
    @PutMapping("/ban/{id}")
    public ResponseEntity<Boolean> banUserById(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok(userService.changeUserStatusById("is_ban",1 ,id )) ;
    }

    /**
     * 取消封禁用户
     * @param id
     * @return
     */
    @PutMapping("/liftTheBan/{id}")
    public ResponseEntity<Boolean> liftTheBan(@PathVariable(value = "id") Integer id){
        return ResponseEntity.ok(userService.changeUserStatusById("is_ban", 0, id));
    }
//
}
