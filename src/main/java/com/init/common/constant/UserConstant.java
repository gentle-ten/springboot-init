package com.init.common.constant;

/**
 * 用户常量
 */
public interface UserConstant {

    /**
     * 用户登录态键
     */
    String USER_LOGIN_STATE = "user_login";

    //  region 权限

    /**
     * 默认角色（也可做 ai 用户角色，输入信息）
     */
    String DEFAULT_ROLE = "user";

    /**
     * 管理员角色
     */
    String ADMIN_ROLE = "admin";

    /**
     * ai 角色设定背景
     */
    String SYSTEM_ROLE = "system";

    /**
     * 被封号
     */
    String BAN_ROLE = "ban";

    // endregion
}
