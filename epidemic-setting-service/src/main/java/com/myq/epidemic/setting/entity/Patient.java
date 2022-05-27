package com.myq.epidemic.setting.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * (Patient)实体类
 *
 * @author makejava
 * @since 2022-02-08 16:13:13
 */
@Data
@TableName("patient")
public class Patient implements Serializable {
    private static final long serialVersionUID = 797756138573027506L;

    /**
     * 患者ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private Integer sex;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private Integer age;

    /**
     * 身高
     */
    @TableField(value = "height")
    private String height;

    /**
     * 体重
     */
    @TableField(value = "weight")
    private String weight;

    /**
     * 感染源
     */
    @TableField(value = "source")
    private String source;

    /**
     * 状态【0-密切接触者，1-受感染者，2-危重症病人，3-死亡者，4-治愈者】
     */
    @TableField(value = "status")
    private Integer status;

    /**
     * 地区ID
     */
    @TableField(value = "region_id")
    private Integer regionId;

    /**
     * 身份证
     */
    @TableField(value = "identity_card")
    private String identityCard;

    /**
     * 人群【0-儿童，1-少年，2-中年，3-老年】
     */
    @TableField(value = "crowd")
    private Integer crowd;

    /**
     * 日期
     */
    @TableField(value = "update_date")
    private Date updateDate;

    /**
     * 联系电话
     */
    @TableField(value = "cellphone")
    private String cellphone;

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

