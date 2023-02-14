package com.core.framework.repository.person;

import com.core.framework.domain.person.Person;
import com.core.framework.repository.IGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IPersonRepository extends IGenericRepository<Person, String> {

    @Query(value = "select e from Person e where e.nationalCode =:nationalCode")
    Person loadByNationalCode(@Param("nationalCode") String nationalCode);

    @Query(value = "select max(e.personCode) from Person e ")
    String getLatestPersonCode();

    @Query(value = "select e from Person e where e.id not in (select u.person.id from  User u )")
    List<Person> unRegisteredPersons();
}
