package com.jiuhaox.boot.adapter.outbound.model;

import com.jiuhaox.boot.adapter.outbound.concepts.PersistenceObject;
import com.jiuhaox.ddd.domain.concepts.AggregateRoot;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.Instant;

@Data
@Accessors(chain = true)
public abstract class BasePO<AGGREGATE extends AggregateRoot<ID>, ID extends Serializable> implements PersistenceObject<AGGREGATE, ID> {
    private Instant createdAt;

    private String createdBy;

    private Instant updatedAt;

    private String updatedBy;
}
