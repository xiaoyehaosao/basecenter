package com.xyhs.b2c.basecenter.controller;


import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xyhs.b2c.basecenter.entity.DeliveryAddressInfo;
import com.xyhs.b2c.basecenter.service.IDeliveryAddressInfoService;
import com.xyhs.b2c.common.tools.api.R;
import com.xyhs.b2c.tradecenter.entity.KfAd;
import com.xyhs.b2c.tradecenter.feign.IKfAdClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljp
 * @since 2020-01-06
 */
@RestController
@RequestMapping("/basecenter/dai")
@Slf4j
public class DeliveryAddressInfoController {

    @Resource
    private IKfAdClient iKfAdClient;

    @Resource
    private IDeliveryAddressInfoService iDeliveryAddressInfoService;

    @GetMapping("queryById")
    public R queryById(@RequestParam("id")Long id){

        R<KfAd>  result = iKfAdClient.queryById(id);
        if(result.isSuccess()){
           KfAd kfAd =  result.getData();
           log.info(JSONObject.toJSONString(kfAd));
        }
        return result;
    }

    @GetMapping("queryPage")
    public IPage<DeliveryAddressInfo> queryPage(){
        Page<DeliveryAddressInfo> page = new Page<>();
        page.setSize(15);
        page.setCurrent(1);
        return iDeliveryAddressInfoService.page(page);
    }

}

