package com.jiuhaox.ddd.domain.model;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.Instant;

@Getter
@ToString
@SuperBuilder
public abstract class BaseEntity<ID extends Serializable> extends BaseIdEntity<ID> {
    private Instant createdAt;

    private String createdBy;

    private Instant updatedAt;

    private String updatedBy;
}
