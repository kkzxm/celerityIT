package com.lingDream;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan("com.lingDream.celerityIT.mapper")
public class DataBaseTestRun {
    public static void main(String[] args) {
        SpringApplication.run(DataBaseTestRun.class, args);
    }
}
