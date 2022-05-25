package com.jiuhaox.boot.exceptions;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;

@Getter
public class AppException extends RuntimeException {
    private final ErrorCode errorCode;

    public AppException(ErrorCode errorCode, Object... params) {
        super(StrUtil.format(errorCode.getMsg(), params));
        this.errorCode = errorCode;
    }
}