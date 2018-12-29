package com.chatweb.only;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chatweb.only.mapper") // 扫描mapper
public class OnlyApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlyApplication.class, args);
    }

}

