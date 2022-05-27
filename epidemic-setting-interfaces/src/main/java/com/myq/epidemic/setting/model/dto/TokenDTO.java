package com.myq.epidemic.setting.model.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class TokenDTO implements Serializable {
    private String userName;
    private String passWord;

    private Integer id;
    private String name;
    private String cellphone;
    private String email;
    private String headImg;
    private Integer sex;
    private Integer role;

}
