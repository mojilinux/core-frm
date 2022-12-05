package com.core.framework.service.person;

import com.core.framework.domain.person.Person;
import com.core.framework.repository.IGenericRepository;
import com.core.framework.repository.person.IPersonRepository;
import com.core.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService extends GenericService<Person, Long> implements IPersonService {

    @Autowired
    private IPersonRepository iPersonRepository;

    protected IGenericRepository<Person, Long> getGenericRepo() {
        return iPersonRepository;
    }


    @Override
    public Person loadByNationalCode(String NationalCode) {
        return iPersonRepository.loadByNationalCode(NationalCode);
    }
}
