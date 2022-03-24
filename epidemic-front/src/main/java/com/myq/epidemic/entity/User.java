package com.myq.epidemic.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-02-08 16:14:28
 */
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -74283745975611562L;
    /**
     * 用户ID
     */
    private Integer id;
    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;
    /**
     * 昵称
     */
    private String name;
    /**
     * 手机号
     */
    private String cellphone;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 头像
     */
    private String headImg;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 角色
     */
    private Integer role;

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

