package com.core.framework.domain.user;

import com.core.framework.domain.BaseEntity;
import com.core.framework.domain.action.Action;
import com.core.framework.domain.person.Person;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
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
    @JoinColumn(name = "Person_ID")
    private Person person;

    @Column(name = "ACTIVATED")
    private boolean activated = false;

    @Column(name = "IS_LOCK")
    private boolean isLock = false;

    @Column(name = "FORCE_UPDATE")
    private boolean forceUpdate = false;

    @Column(name = "USER_LOCK_DATE")
    private Date userLockDate;

    @Column(name = "USER_CREDIT")
    private Date userCredit;

    @Column(name = "PASSWORD_CREDIT")
    private Date passwordCredit;

    //	@ManyToMany(fetch = FetchType.LAZY)
    //	@JoinTable(name = "APP_USER_ACTION", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ACTION_ID") })
    @Transient
    private List<Action> actions;
}