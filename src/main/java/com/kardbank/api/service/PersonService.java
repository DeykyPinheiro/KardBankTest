package com.kardbank.api.service;

import com.kardbank.api.dto.person.ListPersonDto;
import com.kardbank.api.dto.person.SavePersonDto;
import com.kardbank.api.dto.person.UpdatePersonDto;
import com.kardbank.api.model.address.Address;
import com.kardbank.api.model.person.Person;
import com.kardbank.api.repository.PersonRepository;
import com.kardbank.api.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;


//    ao invez de chamar a repository eu tenho que chamar a service e
//    fazer tudo que precisa ser feito la dentro
//    @Autowired
//    private AddressRepository addressRepository;

    @Autowired
    private AddressService addressService;

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;


    public void save(SavePersonDto data) throws Exception {
        System.out.println(data);

        Person old = personRepository.findByEmail(data.email());
        if (old != null) {
            throw new Exception("Usuario Ja Cadastrado");
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
