package com.myq.epidemic.setting.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (Region)实体类
 *
 * @author makejava
 * @since 2022-02-08 16:14:15
 */
@Data
@TableName(value = "region")
public class Region implements Serializable {
    private static final long serialVersionUID = -28075605055147329L;

    /**
     * 地区ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 数量
     */
    @TableField(value = "region_count")
    private Integer regionCount;

    /**
     * 创建时间
     **/
    @TableField(value = "t_create_time", fill = FieldFill.INSERT)
    private LocalDateTime tCreateTime;

    /**
     * 创建人
     **/
    @TableField(value = "t_create_code")
    private String tCreateCode;

    /**
     * 更新时间
     **/
    @TableField(value = "t_update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime tUpdateTime;

    /**
     * 更新人
     **/
    @TableField(value = "t_update_code")
    private String tUpdateCode;

}

