package com.jiuhaox.boot.exceptions;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class AppErrorCodeTest {
    @Test
    void should_return_appexception_when_throwIt_given_error_code() {
        final AppException appException = AppErrorCode.ERR_NET_BUSY.throwIt();
        assertThat(appException).isInstanceOf(AppException.class);
        assertThat(appException.getErrorCode()).isEqualTo(AppErrorCode.ERR_NET_BUSY);
    }
}