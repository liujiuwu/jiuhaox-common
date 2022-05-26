package com.jiuhaox.boot.application.model.resp;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.util.List;

@Value
@Builder
public class PageResp<T> implements Serializable {
    private List<T> content;

    private int page;

    private int size;

    private long total;
}
