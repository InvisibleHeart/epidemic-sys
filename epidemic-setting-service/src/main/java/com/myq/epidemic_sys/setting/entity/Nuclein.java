package com.myq.epidemic_sys.setting.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * (Nuclein)实体类
 *
 * @author makejava
 * @since 2022-02-08 16:12:42
 */
@Data
@TableName("nuclein")
public class Nuclein implements Serializable {
    private static final long serialVersionUID = 165156303617551749L;

    /**
     * 核酸ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 患者ID
     */
    @TableField(value = "patient_id")
    private Integer patientId;

    /**
     * 核酸日期
     */
    @TableField(value = "nuclein_date")
    private Date nucleinDate;

    /**
     * 结果【0-阴，1-阳】
     */
    @TableField(value = "result")
    private Integer result;

    /**
     * 备注
     */
    @TableField(value = "remarks")
    private String remarks;

    /**
     * 创建时间
     **/
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime tCreateTime;

    /**
     * 创建人
     **/
    @TableField(value = "t_create_code")
    private String tCreateCode;

    /**
     * 更新时间
     **/
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime tUpdateTime;

    /**
     * 更新人
     **/
    @TableField(value = "t_update_code")
    private String tUpdateCode;

}

