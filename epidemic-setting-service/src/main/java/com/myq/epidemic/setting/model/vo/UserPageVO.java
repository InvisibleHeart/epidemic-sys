package com.myq.epidemic.setting.model.vo;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

/**
 * @Author 毛一钦
 * @Date 2022/3/1 20:40
 **/
@Data
@Accessors(chain = true)
public class UserPageVO implements Serializable {
    private long current;
    private long size;
    private long total;
    private long page;
    private List records;
    private String name;
    private Integer sex;
    private Integer role;
}
