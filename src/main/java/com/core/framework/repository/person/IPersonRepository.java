package com.core.framework.repository.person;

import com.core.framework.domain.person.Person;
import com.core.framework.repository.IGenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IPersonRepository extends IGenericRepository<Person, Long> {

    @Query(value = "select e from Person e where e.nationalCode =:nationalCode")
    Person loadByNationalCode(@Param("nationalCode") String nationalCode);
}
