package com.core.framework.web.viewModel.user;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AuthenticatedUserViewModel {
	private String       username;
	private String       firstName;
	private String       lastName;
	private List<String> authorities;
}
