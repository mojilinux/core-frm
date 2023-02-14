package com.core.framework.domain.user;

import com.core.framework.domain.BaseEntity;
import com.core.framework.domain.action.Action;
import com.core.framework.domain.person.Person;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "APP_USER")
@GenericGenerator(name = "sequence_db", strategy = "org.hibernate.id.UUIDGenerator")
public class User extends BaseEntity<String> {

    @Size(max = 50)
    @Column(name = "USER_NAME", unique = true, nullable = false)
    private String username;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @OneToOne
    @JoinColumn(name = "Person_ID", unique = true, updatable = false)
    private Person person;

    @Column(name = "ACTIVATED")
    private boolean activated = false;

    @Column(name = "IS_LOCK")
    private boolean isLock = false;

    @Column(name = "FORCE_UPDATE")
    private boolean forceUpdate = false;

    @Column(name = "USER_LOCK_DATE")
    private String userLockDate;

    @Column(name = "USER_CREDIT")
    private String userCredit;

    @Column(name = "PASSWORD_CREDIT")
    private String passwordCredit;

    //    @Formula("SELECT A.* FROM APP_ACTION A INNER JOIN APP_ACTION_GROUP AG ON AG.ACTION_ID = A.ID INNER JOIN APP_USER_GROUP UG ON UG.GROUP_ID = AG.GROUP_ID WHERE UG.USER_ID = ID")
    @Transient
    private List<Action> actions;
}
