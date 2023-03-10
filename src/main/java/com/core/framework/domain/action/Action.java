package com.core.framework.domain.action;

import com.core.framework.domain.BaseEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@GenericGenerator(name = "sequence_db", strategy = "org.hibernate.id.UUIDGenerator")
@Table(name = "APP_ACTION")
public class Action extends BaseEntity<String> {

    @NotNull
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Action parent;

}
