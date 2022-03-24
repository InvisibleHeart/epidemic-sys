package com.myq.epidemic.entity;

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
public class Nuclein implements Serializable {
    private static final long serialVersionUID = 165156303617551749L;
    /**
     * 核酸ID
     */
    private Integer id;
    /**
     * 患者ID
     */
    private Integer patientId;
    /**
     * 核酸日期
     */
    private Date nucleinDate;
    /**
     * 结果【0-阴，1-阳】
     */
    private Integer result;
    /**
     * 备注
     */
    private String remarks;

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

