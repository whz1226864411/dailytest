package com.creat.antest.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/9/18.
 */
@Aspect
@Component
public class UserAspect {
    @Before("execution(* *(..))")
    public void before(){
        System.out.println("开始了！");
    }
}
