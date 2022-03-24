package com.myq.epidemic_sys.setting.model.dto;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author 毛一钦
 * @Date 2022/3/8 13:21
 **/
@Data
public class Patient1DTO implements Serializable {
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

    /**
     *  地区名称
     **/
    private String regionName;
}
