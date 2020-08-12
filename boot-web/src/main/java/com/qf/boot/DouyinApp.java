package com.qf.boot;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@ComponentScan(basePackages = {"com.qf"})
@SpringBootApplication
@MapperScan(basePackages = {"com.qf.boot.dao"})  // 这个表示将这个包路径下的所有接口生成mybatis的动态代理实现类
public class DouyinApp {
    public static void main(String[] args) {
        SpringApplication.run(DouyinApp.class,args);
    }
}
