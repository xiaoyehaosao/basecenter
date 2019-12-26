package com.xyhs.b2c.controller;


import com.xyhs.b2c.service.DeliveryAddressInfoService;
import com.xyhs.common.tools.ExecuteResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author ljp
 * @since 2019-12-23
 */
@RestController
@RequestMapping("/delivery-address-info")
public class DeliveryAddressInfoController {

@Resource
private DeliveryAddressInfoService deliveryAddressInfoService;

    @GetMapping(value ="/sendTest")
    public ExecuteResult testController(String testMsg){

       // deliveryAddressInfoService.page()
        //return result;
        //deliveryAddressInfoService.page()
        return null;
    }


}

