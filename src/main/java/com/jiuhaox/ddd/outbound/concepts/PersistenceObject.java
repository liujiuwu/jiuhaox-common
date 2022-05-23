package com.jiuhaox.ddd.outbound.concepts;

import java.io.Serializable;

public interface PersistenceObject<T> extends Serializable {
    T toDomain();
}
