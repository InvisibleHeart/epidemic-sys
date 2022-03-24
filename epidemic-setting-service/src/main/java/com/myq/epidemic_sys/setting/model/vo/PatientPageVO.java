package com.myq.epidemic_sys.setting.model.vo;


import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Data
@Accessors(chain = true)
public class PatientPageVO implements Serializable {
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
