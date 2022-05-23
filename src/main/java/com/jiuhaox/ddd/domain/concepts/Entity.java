package com.jiuhaox.ddd.domain.concepts;

import java.io.Serializable;

public interface Entity<ID extends Serializable> extends DomainObject {
    ID getId();

    void setId(ID id);
}
