package com.jiuhaox.ddd.domain.concepts;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface Repository<T extends AggregateRoot<ID>, ID extends Serializable> {
    T save(T entity);

    Optional<T> byId(ID id);

    List<T> byIds(Collection<ID> ids);

    long count();

    void delete(ID id);

    void delete(Collection<ID> ids);

    void deleteAll();
}
