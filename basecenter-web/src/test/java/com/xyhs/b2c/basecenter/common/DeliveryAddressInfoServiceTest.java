package com.xyhs.b2c.basecenter.common;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyhs.b2c.basecenter.entity.DeliveryAddressInfo;
import com.xyhs.b2c.basecenter.service.IDeliveryAddressInfoService;
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
    private IDeliveryAddressInfoService deliveryAddressInfoService;


    @Test
    public void findOne(){
        Page<DeliveryAddressInfo> page = new Page<>();
        QueryWrapper<DeliveryAddressInfo> param = new QueryWrapper<>();
        IPage<DeliveryAddressInfo> pageResult =  deliveryAddressInfoService.page(page,param);
        log.info(JSONObject.toJSONString( pageResult));
    }
}
