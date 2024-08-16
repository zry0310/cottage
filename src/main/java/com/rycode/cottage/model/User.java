package com.rycode.cottage.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@Data
public class User implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 用户名
     */
    private String name;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phoneNumber;

    /**
     * 注册邮箱
     */
    private String mail;

    /**
     * 角色ids
     */
    private String roleIds;

    /**
     * 
     */
    private Date createdAt;

    /**
     * 
     */
    private Date updatedAt;

    /**
     * 加密盐
     */
    private String salt;

    /**
     * 是否超级管理员
     */
    private Integer isAdmin;

    /**
     *
     */
    @TableLogic(value = "null", delval = "now()")
    private Date deletedAt;

    private static final long serialVersionUID = 1L;
}