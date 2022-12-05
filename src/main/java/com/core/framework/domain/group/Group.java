package com.core.framework.domain.group;

import com.core.framework.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "APP_GROUP")
public class Group extends BaseEntity<Long> {

	@Column(name = "name")
	private String name;

	@Column(name = "ACTIVE")
	private Boolean active;

}
