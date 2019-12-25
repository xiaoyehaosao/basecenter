package com.xyhs.b2c;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyhs.b2c.entity.DeliveryAddressInfo;
import com.xyhs.b2c.service.DeliveryAddressInfoService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * @author ljp
 * @apiNote
 * @date 10:53 2019/12/25
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
@Component
@Slf4j
public class DeliveryAddressInfoServiceTest {
    @Resource
    private DeliveryAddressInfoService deliveryAddressInfoService;


    @Test
    public void findOne(){
       // List<DeliveryAddressInfo> list =  deliveryAddressInfoService.list();

       // IPage<DeliveryAddressInfo> page = new Ipage
        Page<DeliveryAddressInfo> page = new Page<>();
       // DeliveryAddressInfo param = new DeliveryAddressInfo();
        QueryWrapper<DeliveryAddressInfo> param = new QueryWrapper<>();
        IPage<DeliveryAddressInfo> pageResult =  deliveryAddressInfoService.page(page,param);
        log.info(JSONObject.toJSONString( pageResult));
    }
}
