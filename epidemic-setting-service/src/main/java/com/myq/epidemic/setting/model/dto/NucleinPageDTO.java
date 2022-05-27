package com.myq.epidemic.setting.model.dto;

import lombok.Data;

import java.util.Date;


/**
 * @Author 毛一钦
 * @Date 2022/2/28 22:17
 **/
@Data
public class NucleinPageDTO {

    private long current;
    private long size;
    private long total;
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
     * 患者ID
     */
    private Integer patientId;
}
