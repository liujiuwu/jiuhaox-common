package com.jiuhaox.boot.adapter.outbound.concepts;

import com.jiuhaox.ddd.domain.concepts.AggregateRoot;

import java.io.Serializable;

public interface DomainConverter<AGGREGATE extends AggregateRoot<ID>, PO extends PersistenceObject<AGGREGATE, ID>, ID extends Serializable> {
    PO toPersistenceObject(AGGREGATE aggregate);

    AGGREGATE toAggregate(PO persistenceObject);
}
