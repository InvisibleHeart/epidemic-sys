package com.myq.epidemic.setting.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @Author 毛一钦
 * @Date 2022/2/28 22:16
 **/
@Data
public class MorbidityPageDTO {
    private long current;
    private long size;
    private long total;
    private Date creatDate;
    private String remarks;
    private String situationCon;
    private String patientId;
}
