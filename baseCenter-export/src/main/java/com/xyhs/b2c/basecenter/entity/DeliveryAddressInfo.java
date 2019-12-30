package com.xyhs.b2c.basecenter.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author ljp
 * @since 2019-12-30
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class DeliveryAddressInfo extends BaseEntity {

    private static final long serialVersionUID=1L;

    @TableField("createDate")
    private LocalDateTime createDate;

    @TableField("modifyDate")
    private LocalDateTime modifyDate;

    private Integer sort;

    @TableField("fullName")
    private String fullName;

    private Integer grade;

    private String name;

    @TableField("treePath")
    private String treePath;

    @TableField("parentId")
    private Long parentId;


}
