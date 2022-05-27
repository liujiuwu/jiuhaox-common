package com.jiuhaox.ddd.domain.model;

import lombok.Getter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@ToString
@SuperBuilder
public abstract class BaseIdEntity<ID extends Serializable> {
    private ID id;
}
