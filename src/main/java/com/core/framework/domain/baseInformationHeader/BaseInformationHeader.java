package com.core.framework.domain.baseInformationHeader;

import com.core.framework.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "APP_BASE_INFORMATION_HEADER")
public class BaseInformationHeader extends BaseEntity<Long> {

    @NotNull
    @Column(name = "TOPIC", nullable = false)
    private String topic;

    @Column(name = "active")
    private Boolean active;
}
