package com.jiuhaox.ddd.domain.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum EventStatus {
    PENDING("待处理"),
    SUCCESS("处理成功"),
    FAILED("处理失败");

    private final String name;

}
