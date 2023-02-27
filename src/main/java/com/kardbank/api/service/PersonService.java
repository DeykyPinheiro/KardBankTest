package com.kardbank.api.service;

import com.kardbank.api.dto.person.ListPersonDto;
import com.kardbank.api.dto.person.UpdatePersonDto;
import com.kardbank.api.model.Person;
import com.kardbank.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.kardbank.api.dto.person.SavePersonDto;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public void save(SavePersonDto data) throws Exception {

        Person old = personRepository.findByEmail(data.email());
        if (old != null) {
            throw  new Exception("Usuario Ja Cadastrado");
        } else {
            Person person = new Person(data);
            personRepository.save(person);
        }
    }

    public Page<ListPersonDto> ListAll(Pageable page) {
        Page ListPerson = personRepository.findAllByActiveTrue(page).map(ListPersonDto::new);
        return ListPerson;
    }

    public void update(UpdatePersonDto person) {
        Person old = personRepository.getReferenceById(person.id());
        old.update(person);
    }

    public void delete(Long id) {
        Person old = personRepository.getReferenceById(id);
        old.delete();
    }

}
