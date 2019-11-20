package com.hyzz.controller;

import com.github.pagehelper.PageInfo;
import com.hyzz.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import com.hyzz.pojo.User;

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
     * 通过id修改用户信息,其他参数要与User类一致
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
}
