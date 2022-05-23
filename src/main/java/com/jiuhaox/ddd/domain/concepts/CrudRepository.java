package com.jiuhaox.ddd.domain.concepts;

import java.io.Serializable;
import java.util.Collection;
import java.util.Optional;

public interface CrudRepository<T, ID extends Serializable> extends Repository<T, ID> {
    T save(T entity);

    Optional<T> byId(ID id);

    Collection<T> byIds(Collection<ID> ids);

    long count();

    void delete(ID id);

    void delete(Collection<ID> ids);

    void deleteAll();
}
