package com.jiuhaox.foundation.enums;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RespStatus {
    SUCC, FAIL;

    @JsonValue
    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
