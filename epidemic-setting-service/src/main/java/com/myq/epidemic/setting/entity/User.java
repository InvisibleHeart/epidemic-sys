package com.myq.epidemic.setting.entity;

import com.baomidou.mybatisplus.annotation.*;
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
@TableName("user")
public class User implements Serializable {
    private static final long serialVersionUID = -74283745975611562L;

    /**
     * 用户ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    @TableField(value = "username")
    private String username;

    /**
     * 密码
     */
    @TableField(value = "password")
    private String password;

    /**
     * 昵称
     */
    @TableField(value = "name")
    private String name;

    /**
     * 手机号
     */
    @TableField(value = "cellphone")
    private String cellphone;

    /**
     * 邮箱
     */
    @TableField(value = "email")
    private String email;

    /**
     * 头像
     */
    @TableField(value = "head_img")
    private String headImg;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private Integer sex;

    /**
     * 角色
     */
    @TableField(value = "role")
    private Integer role;

    /**
     * 创建时间
     **/
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime tCreateTime;

    /**
     * 创建人
     **/
    private String tCreateCode;

    /**
     * 更新时间
     **/
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime tUpdateTime;

    /**
     * 更新人
     **/
    private String tUpdateCode;

}

