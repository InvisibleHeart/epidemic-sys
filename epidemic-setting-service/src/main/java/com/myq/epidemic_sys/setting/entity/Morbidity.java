package com.myq.epidemic_sys.setting.entity;


import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * (Morbidity)实体类
 *
 * @author makejava
 * @since 2022-02-08 16:11:54
 */
@Data
@TableName("morbidity")
public class Morbidity implements Serializable {
    private static final long serialVersionUID = 214970591502303715L;
    /**
     * 发病ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 患者ID
     */
    @TableField(value = "patient_id")
    private Integer patientId;
    /**
     * 创建日期
     */
    @TableField(value = "creat_date")
    private Date creatDate;
    /**
     * 发病情况
     */
    @TableField(value = "situation_con")
    private String situationCon;
    /**
     * 备注
     */
    @TableField(value = "remarks")
    private String remarks;

    /**
     * 创建时间
     **/
    @TableField(value = "t_create_time", fill = FieldFill.INSERT)
    private LocalDateTime tCreateTime;

    /**
     * 创建人
     **/
    @TableField(value = "t_create_code", fill = FieldFill.INSERT)
    private String tCreateCode;
    /**
     * 更新时间
     **/
    @TableField(value = "t_update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime tUpdateTime;

    /**
     * 更新人
     **/
    @TableField(value = "t_update_code", fill = FieldFill.INSERT_UPDATE)
    private String tUpdateCode;
}

