package com.xyhs.b2c.basecenter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ljp
 * @apiNote
 * @date 15:07 2019/11/13
 **/
@SpringBootApplication
@MapperScan("com.xyhs.b2c.basecenter.mapper")
public class BaseCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseCenterApplication.class,args);
    }
}
