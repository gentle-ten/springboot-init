package com.init.common.exception;

import lombok.Getter;

/**
 * 自定义错误码
 */
@Getter
public enum ErrorCode {

    /**
     * 系统状态码
     */
    SUCCESS(0, "OK: 执行成功。"),
    ERROR(-1, "ERROR: 执行失败，详见错误信息。"),
    EXPIRE(-2, "EXPIRE: 无登录身份或已超时。"),
    EXCEPTION(-999, "EXCEPTION: 系统异常，详见错误信息。"),

    /**
     * 客户端错误段
     */
    PARAMS_ERROR(40000, "PARAMS_ERROR: 请求参数不正确"),
    NOT_LOGIN_ERROR(40100, "NOT_LOGIN_ERROR: 账号未登录"),
    NO_AUTH_ERROR(40300, "NO_AUTH_ERROR: 没有操作权限"),
    NOT_FOUND_ERROR(40400, "NOT_FOUND_ERROR: 请求数据不存在"),
    METHOD_NOT_ALLOWED(40500, "METHOD_NOT_ALLOWED: 请求方法不正确"),
    LOCKED(42300, "LOCKED: 请求失败，请稍后重试"),
    TOO_MANY_REQUESTS(42900, "TOO_MANY_REQUESTS: 请求过于频繁，请稍后重试"),

    /**
     * 服务端错误段
     */
    FORBIDDEN_ERROR(40300, "FORBIDDEN_ERROR: 禁止访问"),
    SYSTEM_ERROR(50000, "SYSTEM_ERROR: 系统内部异常"),
    OPERATION_ERROR(50001, "OPERATION_ERROR: 操作失败"),
    API_REQUEST_ERROR(50010, "API_REQUEST_ERROR: 接口调用失败"),
    CONFIGURATION_ERROR(50200, "CONFIGURATION_ERROR: 错误的配置项"),

    /**
     * 自定义错误段
     */
    REPEATED_REQUESTS(90000, "REPEATED_REQUESTS: 重复请求，请稍后重试"),
    DEMO_DENY(90100, "DEMO_DENY: 演示模式，禁止写操作"),
    UNKNOWN(99900, "UNKNOWN: 未知错误"),

    /**
     * OSS
     */
    OSS_NOT_EXIST(80101, "OSS_NOT_EXIST: OSS未配置"),
    OSS_EXCEPTION_ERROR(80102, "OSS_EXCEPTION_ERROR: 文件上传失败，请稍后重试"),
    OSS_DELETE_ERROR(80103, "OSS_DELETE_ERROR: 删除失败"),
    OSS_DOWNLOAD_ERROR(80104, "OSS_DOWNLOAD_ERROR: 下载失败"),
    OSS_READ_ERROR(80105, "OSS_READ_ERROR: 资源访问失败"),

    IMAGE_FILE_EXT_ERROR(10050, "IMAGE_FILE_EXT_ERROR: 不支持图片格式"),
    FILE_TYPE_NOT_SUPPORT(10100, "FILE_TYPE_NOT_SUPPORT: 不支持上传的文件类型！"),
    FILE_NOT_EXIST_ERROR(10110, "FILE_NOT_EXIST_ERROR: 上传文件不能为空"),
    FILE_NOT_BIG_ERROR(10120, "FILE_NOT_BIG_ERROR: 上传文件过大"),

    /**
     * 角色
     */
    USER_ROLE_ERROR(10000, "USER_ROLE_ERROR: 角色权限异常");

    /**
     * 状态码
     */
    private final int code;

    /**
     * 信息
     */
    private final String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
