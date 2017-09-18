package com.creat.antest.controller;

import com.creat.antest.po.User;
import com.creat.antest.service.UserFunctionTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/9/18.
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserFunctionTest userFunctionTest;

    @RequestMapping(value = "/getResult")
    public User getResult(@RequestBody User user1){
        User user = new User();
        user.setUserName(user1.getUserName());
        user.setAge(20);
        return user;
    }
}
