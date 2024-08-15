package com.rycode.cottage.model;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName admin_info
 */
@Data
public class AdminInfo implements Serializable {
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
    private String userSalt;

    /**
     * 是否超级管理员
     */
    private Integer isAdmin;

    private static final long serialVersionUID = 1L;
}