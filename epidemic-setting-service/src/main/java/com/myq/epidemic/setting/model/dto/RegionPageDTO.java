package com.myq.epidemic.setting.model.dto;

import lombok.Data;


/**
 * @Author 毛一钦
 * @Date 2022/2/28 22:18
 **/
@Data
public class RegionPageDTO {
    private long current;
    private long size;
    private long total;
    private String name;
}
