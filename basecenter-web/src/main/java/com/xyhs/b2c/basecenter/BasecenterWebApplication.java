package com.xyhs.b2c.basecenter;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringCloudApplication
@EnableFeignClients("com.xyhs.b2c.*.feign*")
public class BasecenterWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(BasecenterWebApplication.class, args);
    }

}
