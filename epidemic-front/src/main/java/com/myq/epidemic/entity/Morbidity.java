package com.myq.epidemic.entity;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (Morbidity)实体类
 *
 * @author makejava
 * @since 2022-02-08 16:11:54
 */
@Data
public class Morbidity implements Serializable {
    private static final long serialVersionUID = 214970591502303715L;
    /**
     * 发病ID
     */
    private Integer id;
    /**
     * 患者ID
     */
    private Integer patientId;
    /**
     * 创建日期
     */
    private LocalDateTime creatDate;
    /**
     * 发病情况
     */
    private String situationCon;
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

