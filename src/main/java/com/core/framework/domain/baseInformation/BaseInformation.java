package com.core.framework.domain.baseInformation;

import com.core.framework.domain.BaseEntity;
import com.core.framework.domain.baseInformationHeader.BaseInformationHeader;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "APP_BASE_INFORMATION")
public class BaseInformation extends BaseEntity<Long> {

    @NotNull
    @Column(name = "TOPIC", nullable = false)
    private String topic;

    @Column(name = "code", nullable = false, unique = true)
    private String code;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private BaseInformationHeader parent;

    @ManyToOne
    @JoinColumn(name = "master_information_id")
    private BaseInformation masterBaseInformation;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "is_default")
    private Boolean isDefault;

    @Column(name = "description")
    private String description;
    //hierarchicode
    //islock
}
