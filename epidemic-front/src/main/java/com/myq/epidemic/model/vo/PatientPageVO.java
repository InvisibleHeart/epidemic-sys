package com.myq.epidemic.model.vo;


import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class PatientPageVO{
    private long current;
    private long size;
    private long total;
    private long page;
    private List records;
    private String name;
    private String source;
    private Integer sex;
    private Integer status;
    private Integer regionId;
    private Integer crowd;
}
