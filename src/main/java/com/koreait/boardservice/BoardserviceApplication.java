package com.koreait.boardservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.koreait.boardservice.mapper")
public class BoardserviceApplication {
    public static void main(String[] args) {
        SpringApplication.run(BoardserviceApplication.class, args);
    }
}
