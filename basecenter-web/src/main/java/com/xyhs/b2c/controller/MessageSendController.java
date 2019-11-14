package com.xyhs.b2c.controller;

import com.xyhs.b2c.ExecuteResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ljp
 * @apiNote
 * @date 9:45 2019/11/14
 **/
@RestController
@RequestMapping(value = "message")
public class MessageSendController {

     @GetMapping(value ="/sendTest")
     public ExecuteResult testController(String testMsg){
         ExecuteResult result = new ExecuteResult();
         result.setResultMessage(testMsg);
         return result;
     }
}
