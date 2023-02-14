package com.core.framework.web.viewModel.user;

import com.core.framework.web.viewModel.BaseEntityViewModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LiteUserViewModel extends BaseEntityViewModel<String> {
    private String username;
    private String personCode;
    private String personId;
    private String firstName;
    private String lastName;
    private String fullName;
    private boolean activated;
    private boolean forceUpdate;
    private boolean isLock;

    public String getFullName() {
        return this.firstName + ' ' + this.lastName;
    }
}
