package com.rycode.cottage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.rycode.cottage.mapper")
public class CottageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CottageApplication.class, args);
    }

}
