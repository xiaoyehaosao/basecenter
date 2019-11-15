package com.xyhs.b2c.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ljp
 * @apiNote
 * @date 15:27 2019/11/15
 **/
@Data
public class TestDTO implements Serializable {


    private static final long serialVersionUID = -1928000154351738907L;

    /**
     * id
     */
    private Long id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 生日
     */
    private Date birthDay;


}
