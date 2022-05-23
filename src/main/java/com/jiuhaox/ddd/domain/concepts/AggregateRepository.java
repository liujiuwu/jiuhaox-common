package com.jiuhaox.ddd.domain.concepts;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface AggregateRepository<T extends AggregateRoot<ID>, ID extends Serializable> extends CrudRepository<T, ID> {
    List<T> byIds(Collection<ID> ids);
}
