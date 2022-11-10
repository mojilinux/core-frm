package com.lami.framework.domain.userGroup;

import com.lami.framework.domain.BaseEntity;
import com.lami.framework.domain.action.Action;
import com.lami.framework.domain.group.Group;
import com.lami.framework.domain.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "APP_USER_GROUP")
public class UserGroup extends BaseEntity<Long> {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_ID")
	private User user;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "GROUP_ID")
	private Group group;

}
