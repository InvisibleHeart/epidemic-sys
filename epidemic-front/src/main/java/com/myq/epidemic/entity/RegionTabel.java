package com.myq.epidemic.entity;

import lombok.Data;

@Data
public class RegionTabel {

    /**
     * 地区
     */
    private String name;

    /**
     * 密切接触者
     */
    private Integer patient1;

    /**
     * 受感染者
     */
    private Integer patient2;

    /**
     * 危重症病人
     */
    private Integer patient3;

    /**
     * 死亡者
     */
    private Integer patient4;

    /**
     * 治愈者
     */
    private Integer patient5;

    /**
     * 正常
     */
    private Integer patient6;
}
