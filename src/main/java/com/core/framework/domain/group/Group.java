package com.core.framework.domain.group;

import com.core.framework.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "APP_GROUP")
@GenericGenerator(name = "sequence_db", strategy = "org.hibernate.id.UUIDGenerator")
public class Group extends BaseEntity<String> {

    @Column(name = "name")
    private String name;

    @Column(name = "ACTIVE")
    private Boolean active;

}
