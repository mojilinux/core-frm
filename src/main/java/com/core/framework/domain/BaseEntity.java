package com.core.framework.domain;

import com.core.framework.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_db")
    private T id;

    @CreatedBy
    @ManyToOne
    @JoinColumn(name = "created_by", updatable = false)
    private User createdBy;

    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @JsonIgnore
    private Date createdDate = Date.from(Instant.now());

    @ManyToOne
    @JoinColumn(name = "updated_by")
    private User updatedBy;

    @LastModifiedDate
    @Column(name = "updated_date")
    @JsonIgnore
    private Date updatedDate;

}
