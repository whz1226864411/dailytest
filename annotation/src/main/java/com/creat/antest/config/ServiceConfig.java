package com.creat.antest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * Created by Administrator on 2017/9/18.
 */
@EnableAspectJAutoProxy
@Configuration
@ComponentScan("com.creat.antest.service.impl")
public class ServiceConfig {
}
