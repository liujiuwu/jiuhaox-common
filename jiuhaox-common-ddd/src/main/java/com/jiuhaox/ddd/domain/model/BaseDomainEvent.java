package com.jiuhaox.ddd.domain.model;

import com.jiuhaox.ddd.domain.concepts.AggregateRoot;
import com.jiuhaox.ddd.domain.concepts.DomainEvent;
import com.jiuhaox.ddd.domain.enums.EventStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@ToString
@SuperBuilder
public abstract class BaseDomainEvent<AGGREGATE extends AggregateRoot<DOMAIN_ID>, DOMAIN_ID extends Serializable, ID extends Serializable> extends BaseEntity<ID> implements DomainEvent<AGGREGATE> {
    private DOMAIN_ID domainId;

    private EventStatus status;

    private LocalDateTime occurredOn;

    private AGGREGATE data;

    /**
     * 修改时间状态为成功
     */
    public void handleSuccess() {
        this.status = status.SUCCESS;
    }

    /**
     * 修改事件状态为失败
     */
    public void handleFailed() {
        this.status = status.FAILED;
    }
}
