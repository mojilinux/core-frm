package com.core.framework.web.viewModel.user;

import com.core.framework.web.viewModel.BaseEntityViewModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserViewModel extends BaseEntityViewModel<String> {
	private String username;
	private String password;
}
