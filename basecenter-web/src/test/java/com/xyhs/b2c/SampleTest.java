package com.xyhs.b2c;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author ljp
 * @apiNote
 * @date 16:36 2019/12/3
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Component
@PropertySource(value = {"classpath:application-dev.yml"})
public class SampleTest {
    @Value("${spring.datasource.url}")
    public String port;
    @Test
    public void codeGenerator()  {
        String path2 =System.getProperty("user.dir");
        System.out.println(path2);
        System.out.println(port);
    }


}
