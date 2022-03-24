package com.myq.epidemic.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (Region)实体类
 *
 * @author makejava
 * @since 2022-02-08 16:14:15
 */
@Data
public class Region implements Serializable {
    private static final long serialVersionUID = -28075605055147329L;
    /**
     * 地区ID
     */
    private Integer id;
    /**
     * 名称
     */
    private String name;
    /**
     * 数量
     */
    private Integer regionCount;

    /**
     * 创建时间
     **/
    private LocalDateTime tCreateTime;

    /**
     * 创建人
     **/
    private String tCreateCode;

    /**
     * 更新时间
     **/
    private LocalDateTime tUpdateTime;

    /**
     * 更新人
     **/
    private String tUpdateCode;

}

