package com.myq.epidemic_sys.setting.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class RegionItemDTO implements Serializable {

    private String name;

    private Integer count;

    private Integer status;

}
