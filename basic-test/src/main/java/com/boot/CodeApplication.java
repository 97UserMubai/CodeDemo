package com.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.boot.mapper"})
public class CodeApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodeApplication.class);
    }
}
