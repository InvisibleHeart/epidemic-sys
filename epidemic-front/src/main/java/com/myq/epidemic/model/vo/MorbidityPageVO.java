package com.myq.epidemic.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @Author 毛一钦
 * @Date 2022/2/28 21:09
 **/
@Data
@Accessors(chain = true)
public class MorbidityPageVO {
    private long current;
    private long size;
    private long total;
    private long page;
    private List records;
    private String creatDate;
    private String remarks;
    private String situationCon;
    private String patientId;
}
