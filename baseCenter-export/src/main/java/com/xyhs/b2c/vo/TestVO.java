package com.xyhs.b2c.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author ljp
 * @apiNote
 * @date 15:28 2019/11/15
 **/
@Data
public class TestVO implements Serializable {

    private static final long serialVersionUID = -7208179790842632292L;
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
