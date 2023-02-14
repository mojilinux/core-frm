package com.core.framework.service.person;

import com.core.framework.domain.person.Person;
import com.core.framework.service.IGenericService;

import java.util.List;

public interface IPersonService extends IGenericService<Person, String> {

    Person loadByNationalCode(String title);

    String save(Person person);

    List<Person> unRegisteredPersons();
}
