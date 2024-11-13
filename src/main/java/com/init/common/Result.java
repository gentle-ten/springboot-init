package com.init.common;

import com.init.common.exception.ErrorCode;
import lombok.Data;
import org.springframework.util.Assert;

/**
 * 执行结果返回类
 */
@Data
public class Result {

    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(ErrorCode.SUCCESS.getCode(), data, ErrorCode.SUCCESS.getMessage());
    }

    public static <T> BaseResponse<T> error(T data) {
        return new BaseResponse<>(ErrorCode.ERROR.getCode(), data, ErrorCode.ERROR.getMessage());
    }


    /**
     * 自定义失败信息
     *
     * @param errorCode 自定义错误码
     */
    public static BaseResponse<ErrorCode> error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode);
    }

    // ---------------------------------------- static: ok ----------------------------------------
    public static BaseResponse<String> success() {
        return new BaseResponse<>(ErrorCode.SUCCESS.getCode(), ErrorCode.SUCCESS.getMessage(), ErrorCode.SUCCESS.getMessage());
    }

    public static <T> BaseResponse<T> success(T data, String message) {
        return new BaseResponse<>(ErrorCode.SUCCESS.getCode(), data, java.lang.String.format("%s", message));
    }

    // -------------------------------------- static: error --------------------------------------
    public static BaseResponse<String> error() {
        return new BaseResponse<>(ErrorCode.ERROR.getCode(), ErrorCode.ERROR.getMessage(), ErrorCode.ERROR.getMessage());
    }

    public static BaseResponse<String> error(int code, String message) {
        Assert.isTrue(code != ErrorCode.SUCCESS.getCode(), "code 必须是错误的！");
        return new BaseResponse<>(code, null, message);
    }


}
