package com.jiuhaox.boot.core.exceptions;

import lombok.SneakyThrows;

public interface ErrorCode {
    String name();

    String getMsg();

    @SneakyThrows
    default AppException throwIt() {
        return new AppException(this);
    }
}
