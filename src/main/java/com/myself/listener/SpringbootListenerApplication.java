package com.myself.listener;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.myself.listener.mapper")
public class SpringbootListenerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootListenerApplication.class, args);
    }

}
