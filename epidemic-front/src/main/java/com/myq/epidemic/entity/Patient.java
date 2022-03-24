package com.myq.epidemic.entity;

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
public class Patient implements Serializable {
    private static final long serialVersionUID = 797756138573027506L;
    /**
     * 患者ID
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 年龄
     */
    private Integer age;
    /**
     * 身高
     */
    private String height;
    /**
     * 体重
     */
    private String weight;
    /**
     * 感染源
     */
    private String source;
    /**
     * 状态【0-密切接触者，1-受感染者，2-危重症病人，3-死亡者，4-治愈者】
     */
    private Integer status;
    /**
     * 地区ID
     */
    private Integer regionId;
    /**
     * 身份证
     */
    private String identityCard;
    /**
     * 人群【0-儿童，1-少年，2-中年，3-老年】
     */
    private Integer crowd;
    /**
     * 日期
     */
    private Date updateDate;
    /**
     * 联系电话
     */
    private String cellphone;

    /**
     * 创建时间
     **/
    private LocalDateTime tCreateTime;

    /**
     * 创建人
     **/
    private String tCreateCode;

    /**
     * 更新时间
     **/
    private LocalDateTime tUpdateTime;

    /**
     * 更新人
     **/
    private String tUpdateCode;

}

