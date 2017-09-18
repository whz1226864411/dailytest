package com.creat.antest.service.impl;

import com.creat.antest.service.UserFunctionTest;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/18.
 */
@Service
public class UserFunctionTestImpl implements UserFunctionTest{
    public String sayHello() {
        return "hello";
    }
}
