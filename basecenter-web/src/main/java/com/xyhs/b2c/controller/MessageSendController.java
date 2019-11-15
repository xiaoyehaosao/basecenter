package com.xyhs.b2c.controller;

import com.xyhs.b2c.ExecuteResult;
import com.xyhs.b2c.dto.TestDTO;
import com.xyhs.b2c.vo.TestVO;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

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


     @PostMapping(value = "testPost")
     public ExecuteResult<TestVO> testPostController(@RequestBody TestVO testVO){
         ExecuteResult<TestVO> result = new ExecuteResult<>();
         testVO.setBirthDay(new Date());
         result.setResult(testVO);
         result.setResultMessage("This is a test post");
         return result;
     }
}
