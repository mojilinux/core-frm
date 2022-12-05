package com.core.framework.web.viewModel.baseInformation;

import com.core.framework.web.viewModel.BaseEntityViewModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseInformationViewModel extends BaseEntityViewModel<Long> {
    private String topic;
    private String code;
    private Integer parentId;
    private boolean active;
    private boolean isDefault;
    private String description;
}
