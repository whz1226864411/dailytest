package com.creat.antest.start;

import com.creat.antest.config.AopConfig;
import com.creat.antest.config.ServiceConfig;
import com.creat.antest.service.UserFunctionTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Administrator on 2017/9/18.
 */
public class Main {

    public static void main(String[] args){
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(ServiceConfig.class);
        context.register(AopConfig.class);
        UserFunctionTest test = context.getBean(UserFunctionTest.class);
        test.sayHello();
        context.close();
    }
}
