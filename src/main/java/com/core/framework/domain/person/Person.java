package com.core.framework.domain.person;

import com.core.framework.domain.BaseEntity;
import com.core.framework.domain.baseInformation.BaseInformation;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.sql.Blob;

@Getter
@Setter
@Entity
@Table(name = "APP_PERSON")
@GenericGenerator(name = "sequence_db", strategy = "org.hibernate.id.UUIDGenerator")
public class Person extends BaseEntity<String> {

    @Column(name = "PERSON_CODE")
    private String personCode;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "NATIONAL_CODE")
    private String nationalCode;

    @Column(name = "FATHER_NAME")
    private String fatherName;

    @ManyToOne
    @JoinColumn(name = "GENDER_ID")
    private BaseInformation gender;

    @Column(name = "ACTIVE")
    private Boolean active;

    @Email
    @Size(min = 5, max = 254)
    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PERSON_IMAGE")
    private Blob personImage;

    @Column(name = "CELLPHONE")
    private String cellPhone;

    @ManyToOne
    @JoinColumn(name = "MARRIAGE_STATUS_ID")
    private BaseInformation marriageStatus;

    @ManyToOne
    @JoinColumn(name = "EDUCATION_LEVEL_ID")
    private BaseInformation educationLevel;

    @Column(name = "BIRTH_DATE")
    private String birthDate;

    @ManyToOne
    @JoinColumn(name = "BIRTH_PLACE_STATE_ID")
    private BaseInformation birthPlaceState;

    @ManyToOne
    @JoinColumn(name = "BIRTH_PLACE_CITY_ID")
    private BaseInformation birthPlaceCity;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "DESCRIPTION")
    private String description;
}
