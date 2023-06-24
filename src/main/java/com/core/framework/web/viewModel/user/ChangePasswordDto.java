package com.core.framework.web.viewModel.user;

import lombok.Data;

@Data
public class ChangePasswordDto {
	private String oldPass;
	private String newPass;
	private String rePass;
}
