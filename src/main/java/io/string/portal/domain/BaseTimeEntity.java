package io.string.portal.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {

    @CreatedDate
    @Column(name = "create_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDateTime;

    @LastModifiedDate
    @Column(name = "update_datetime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date updateDateTime;

}
