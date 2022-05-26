package com.jiuhaox.boot.adapter.outbound.concepts;

import com.jiuhaox.ddd.domain.concepts.AggregateRoot;

import java.io.Serializable;

public interface PersistenceObject<AGGREGATE extends AggregateRoot<ID>, ID extends Serializable> extends Serializable {
    AGGREGATE toAggregate();
}
