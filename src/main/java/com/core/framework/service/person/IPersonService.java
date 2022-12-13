package com.core.framework.service.person;

import com.core.framework.domain.person.Person;
import com.core.framework.service.IGenericService;

public interface IPersonService extends IGenericService<Person, String> {

    public Person loadByNationalCode(String title);
}
