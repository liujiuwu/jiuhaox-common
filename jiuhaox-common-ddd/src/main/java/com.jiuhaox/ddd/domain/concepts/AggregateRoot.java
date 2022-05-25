package com.jiuhaox.ddd.domain.concepts;

import java.io.Serializable;

public interface AggregateRoot<ID extends Serializable> extends Entity<ID> {
}
