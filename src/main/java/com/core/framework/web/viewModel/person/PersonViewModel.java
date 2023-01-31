package com.core.framework.web.viewModel.person;

import com.core.framework.web.viewModel.BaseEntityViewModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PersonViewModel extends BaseEntityViewModel<String> {
    private String personCode;
    private String firstName;
    private String lastName;
    private String nationalCode;
    private String fatherName;
    private boolean active;
    private String email;
    private String personImage;
    private String cellPhone;
    private String genderId;
    private String genderTopic;
    private String genderCode;
    private String marriageStatusId;
    private String marriageStatusTopic;
    private String marriageStatusCode;
    private String educationLevelId;
    private String educationLevelTopic;
    private String educationLevelCode;
    private String birthDate;
    private String birthPlaceStateId;
    private String birthPlaceStateTopic;
    private String birthPlaceStateCode;
    private String birthPlaceCityId;
    private String birthPlaceCityTopic;
    private String birthPlaceCityCode;
    private String address;
    private String description;
}
