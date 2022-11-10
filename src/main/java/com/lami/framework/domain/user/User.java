package com.lami.framework.domain.user;

import com.lami.framework.domain.BaseEntity;
import com.lami.framework.domain.action.Action;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "APP_USER")
public class User extends BaseEntity<Long> {

	@Size(max = 50)
	@Column(name = "USER_NAME", unique = true, nullable = false)
	private String username;

	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Size(max = 50)
	@Column(name = "FIRST_NAME", nullable = false)
	private String firstName;

	@Size(max = 50)
	@Column(name = "LAST_NAME", nullable = false)
	private String lastName;

	@Email
	@Size(min = 5, max = 254)
	@Column(name = "EMAIL")
	private String email;

	@Column(name = "ACTIVATED")
	private boolean activated = false;

//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "APP_USER_ACTION", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ACTION_ID") })
	@Transient
	private List<Action> actions;

}
