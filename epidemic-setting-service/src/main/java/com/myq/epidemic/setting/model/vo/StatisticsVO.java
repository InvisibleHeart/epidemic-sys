package com.myq.epidemic.setting.model.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author 毛一钦
 * @Date 2022/3/1 19:26
 **/
@Data
public class StatisticsVO implements Serializable {
    private String name;
    private Object value;
    private String date;

}
