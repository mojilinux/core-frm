package com.core.framework.web.viewModel.baseInformationHeader;

import com.core.framework.web.viewModel.BaseEntityViewModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseInformationHeaderViewModel extends BaseEntityViewModel<String> {
    private String topic;
    private String code;
    private boolean active;
}
