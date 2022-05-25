package com.jiuhaox.boot.exceptions;

import lombok.SneakyThrows;

public interface ErrorCode {
    String name();

    String getMsg();

    @SneakyThrows
    default AppException throwIt() {
        return new AppException(this);
    }
}
