package com.jiuhaox.ddd.domain.model;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Getter
@SuperBuilder
public abstract class BaseIdEntity<ID extends Serializable> {
    private ID id;
}
