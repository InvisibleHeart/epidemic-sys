package com.myq.epidemic.setting.model.dto;

import lombok.Data;

/**
 * @Author 毛一钦
 * @Date 2022/2/28 22:17
 **/
@Data
public class PatientPageDTO{
    private long current;
    private long size;
    private long total;
    private String name;
    private String source;
    private Integer sex;
    private Integer status;
    private Integer regionId;
    private Integer crowd;
}
