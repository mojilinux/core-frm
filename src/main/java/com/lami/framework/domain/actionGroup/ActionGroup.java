package com.lami.framework.domain.actionGroup;

import com.lami.framework.domain.BaseEntity;
import com.lami.framework.domain.action.Action;
import com.lami.framework.domain.group.Group;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "APP_ACTION_GROUP")
public class ActionGroup extends BaseEntity<Long> {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACTION_ID")
	private Action action;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GROUP_ID")
	private Group group;

}
