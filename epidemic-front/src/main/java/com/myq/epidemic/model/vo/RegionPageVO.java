package com.myq.epidemic.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;


@Data
@Accessors(chain = true)
public class RegionPageVO {
    private long current;
    private long size;
    private long total;
    private long page;
    private List records;
    private String name;

}
