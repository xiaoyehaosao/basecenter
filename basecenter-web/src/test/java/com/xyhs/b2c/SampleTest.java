package com.xyhs.b2c;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author ljp
 * @apiNote
 * @date 16:36 2019/12/3
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Autowired
    private DeliveryAddressInfoMapper deliveryAddressInfoMapper;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<DeliveryAddressInfo> userList = deliveryAddressInfoMapper.selectList(null);
        userList.forEach(System.out::println);
    }
}
