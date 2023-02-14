package com.core.framework.service.person;

import com.core.framework.domain.person.Person;
import com.core.framework.repository.IGenericRepository;
import com.core.framework.repository.person.IPersonRepository;
import com.core.framework.service.GenericService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PersonService extends GenericService<Person, String> implements IPersonService {

    @Autowired
    private IPersonRepository iPersonRepository;

    protected IGenericRepository<Person, String> getGenericRepo() {
        return iPersonRepository;
    }


    @Override
    public Person loadByNationalCode(String NationalCode) {
        return iPersonRepository.loadByNationalCode(NationalCode);
    }

    @Override
    @Transactional
    public String save(Person entity) {
        if (entity.getId() == null) {
            entity.setPersonCode(generateNewPersonCode());
        }
        return super.save(entity);
    }

    private String generateNewPersonCode() {
        String latestPersonCode = iPersonRepository.getLatestPersonCode();
        if (latestPersonCode == null) {
            return "10000";
        } else {
            return String.valueOf(Integer.valueOf(latestPersonCode) + 1);
        }
    }

    @Override
    public List<Person> unRegisteredPersons() {
        return iPersonRepository.unRegisteredPersons();
    }
}
