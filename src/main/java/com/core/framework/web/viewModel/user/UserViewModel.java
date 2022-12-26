package com.core.framework.web.viewModel.user;

import com.core.framework.web.viewModel.BaseEntityViewModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class UserViewModel extends BaseEntityViewModel<String> {
	private String  username;
	private String  password;
	private String  personId;
	private String  firstName;
	private String  lastName;
	private boolean activated;
	private boolean isLock;
	private boolean forceUpdate;
	private Date    userLockDate;
	private Date    userCredit;
	private Date    passwordCredit;
}
