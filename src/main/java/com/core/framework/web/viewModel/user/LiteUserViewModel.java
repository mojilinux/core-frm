package com.core.framework.web.viewModel.user;

import com.core.framework.web.viewModel.BaseEntityViewModel;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class LiteUserViewModel extends BaseEntityViewModel<String> {
    private String username;
    private String personId;
    private String firstName;
    private String lastName;
    private boolean activated;
    private boolean isLock;
}
