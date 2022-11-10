package com.lami.framework.web.viewModel.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserViewModel {
	private Long id ;
	private String username;
	private String firstName;
	private String lastName;
	private String password;
	private String email;
}
