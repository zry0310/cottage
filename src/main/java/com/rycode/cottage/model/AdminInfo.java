package com.rycode.cottage.model;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * 软删除已实现
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
     * 逻辑删除时间
     */
    @TableLogic(value = "null", delval = "now()")
    private Date deletedAt;

    /**
     * 加密盐
     */
    private String userSalt;

    /**
     * 是否超级管理员
     */
    private Integer isAdmin;

    /**
     * 软删除标识
     */
//    @TableLogic
//    private Integer isDeleted;

    private static final long serialVersionUID = 1L;
}