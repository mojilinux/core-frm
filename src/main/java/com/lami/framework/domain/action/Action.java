package com.lami.framework.domain.action;

import com.lami.framework.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "APP_ACTION")
public class Action extends BaseEntity<Long> {

	@NotNull
	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "code", nullable = false, unique = true)
	private String code;

	@Column(name = "parent_id")
	private Action parent;

}
