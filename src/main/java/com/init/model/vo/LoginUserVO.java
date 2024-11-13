package com.init.model.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 已登录用户视图（脱敏）
 **/
@Schema(name = "LoginUserVO", description = "已登录用户视图（脱敏）")
@Data
public class LoginUserVO implements Serializable {

    /**
     * 用户 id
     */
    @Schema(name = "id", description = "用户 id")
    private Long id;

    /**
     * 用户昵称
     */
    @Schema(name = "userName", description = "用户昵称")
    private String userName;

    /**
     * 用户头像
     */
    @Schema(name = "userAvatar", description = "用户头像")
    private String userAvatar;

    /**
     * 用户简介
     */
    @Schema(name = "userProfile", description = "用户简介")
    private String userProfile;

    /**
     * 用户角色：user/admin/ban
     */
    @Schema(name = "userRole", description = "用户角色：user/admin/ban）")
    private String userRole;

    /**
     * 创建时间
     */
    @Schema(name = "createTime", description = "创建时间")
    private Date createTime;

    /**
     * 更新时间
     */
    @Schema(name = "updateTime", description = "更新时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;
}