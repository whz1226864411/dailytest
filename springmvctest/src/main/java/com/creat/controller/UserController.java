package com.creat.controller;

import com.creat.po.User;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/16.
 */
public class UserController extends AbstractController{
    protected ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        List<User> userList = new ArrayList<User>();
        User user = new User();
        user.setUserName("小明");
        user.setAge(14);
        User user1 = new User();
        user1.setUserName("大明");
        user1.setAge(15);
        userList.add(user);
        userList.add(user1);
        return new ModelAndView("userList","users",userList);
    }
}
