package com.core.framework.web.viewModel.person;

import com.core.framework.web.viewModel.BaseEntityViewModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LimitedPersonViewModel extends BaseEntityViewModel<String> {
    private String personCode;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private boolean active;
    private String personImage;
    private String FullName;

    public String getFullName() {
        return this.personCode + " - " + this.firstName + " " + this.lastName;
    }
}
