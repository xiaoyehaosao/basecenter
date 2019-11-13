package com.xyhs.b2c;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ljp
 * @apiNote
 * @date 15:07 2019/11/13
 **/
@SpringCloudApplication
@EnableDiscoveryClient
public class BaseCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(BaseCenterApplication.class,args);
    }
}
