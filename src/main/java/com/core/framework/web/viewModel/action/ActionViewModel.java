package com.core.framework.web.viewModel.action;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionViewModel {
	private Long   id;
	private String title;
	private String code;
	private Long   parentId;
}
