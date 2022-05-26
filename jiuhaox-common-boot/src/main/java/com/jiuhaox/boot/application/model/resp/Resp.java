package com.jiuhaox.boot.application.model.resp;

import cn.hutool.core.util.StrUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.jiuhaox.boot.core.exceptions.AppErrorCode;
import com.jiuhaox.boot.core.enums.RespStatus;
import com.jiuhaox.boot.core.exceptions.ErrorCode;

import java.beans.Transient;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static com.jiuhaox.boot.core.enums.RespStatus.FAIL;
import static com.jiuhaox.boot.core.enums.RespStatus.SUCC;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record Resp<T>(RespStatus status, T data, String code, String msg) {
    public static <T> Resp<T> ok() {
        return ok(null);
    }

    public static <T> Resp<T> ok(T data) {
        return new Resp<>(SUCC, data, null, null);
    }

    public static <T> Resp<T> fail(String msg) {
        return new Resp<>(FAIL, null, AppErrorCode.ERR_SYS_ERROR.name(), msg);
    }

    public static <T> Resp<T> fail(ErrorCode errorCode, Object... params) {
        return new Resp<>(FAIL, null, errorCode.name(), StrUtil.format(errorCode.getMsg(), params));
    }

    @JsonIgnore
    @Transient
    public boolean isSucc() {
        return this.status == SUCC;
    }

    @JsonIgnore
    @Transient
    public boolean isFail() {
        return this.status == FAIL;
    }

    @JsonIgnore
    @Transient
    public void ifSucc(Consumer<T> succConsumer) {
        if (this.status == SUCC) {
            succConsumer.accept(data);
        }
    }

    @JsonIgnore
    @Transient
    public void ifSuccOrElse(Consumer<T> succConsumer, BiConsumer<String, String> failConsumer) {
        if (this.status == SUCC) {
            succConsumer.accept(data);
        } else {
            failConsumer.accept(this.code(), this.msg());
        }
    }
}
