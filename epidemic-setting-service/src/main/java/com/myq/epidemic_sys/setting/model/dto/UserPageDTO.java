package com.myq.epidemic_sys.setting.model.dto;

import lombok.Data;

/**
 * @Author 毛一钦
 * @Date 2022/3/1 21:06
 **/
@Data
public class UserPageDTO{
    private long current;
    private long size;
    private long total;
    private String name;
    private Integer sex;
    private Integer role;
}
