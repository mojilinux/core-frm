package com.core.framework.web.viewModel.group;

import com.core.framework.domain.BaseEntity;
import com.core.framework.web.viewModel.BaseEntityViewModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroupViewModel extends BaseEntityViewModel<String> {
	private String  name;
	private Boolean active;
}
