package com.core.framework.web.viewModel.user;

import com.core.framework.web.viewModel.BaseEntityViewModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserViewModel extends BaseEntityViewModel<String> {
    private String personId;
    private String personCode;
    private String firstName;
    private String lastName;
    private String fullName;
    private String username;
    private String password;
    private boolean activated;
    private boolean isLock;
    private boolean forceUpdate;
    private String userLockDate;
    private String userCredit;
    private String passwordCredit;

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
