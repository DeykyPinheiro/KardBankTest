package com.kardbank.api.service;

import com.kardbank.api.dto.addressDto.ListAddressDto;
import com.kardbank.api.dto.person.ListPersonDto;
import com.kardbank.api.dto.person.SavePersonDto;
import com.kardbank.api.dto.person.UpdatePersonDto;
import com.kardbank.api.model.address.Address;
import com.kardbank.api.model.person.Person;
import com.kardbank.api.model.phoneNumber.PhoneNumber;
import com.kardbank.api.repository.AddressRepository;
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
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    public void save(SavePersonDto data) throws Exception {
        Person old = personRepository.findByEmail(data.email());
        if (old != null) {
            throw new Exception("Usuario Ja Cadastrado");
        } else {
            Person person = new Person(data);
            personRepository.save(person);
        }
    }

//    funciona porem quero testar o que vai servir o front 100%
//    public List<ListPersonDto> ListAll() {
//        List<ListPersonDto> ListPerson = personRepository.findAll().stream().map(ListPersonDto::new).collect(Collectors.toList());
//        return ListPerson;
//    }

    public List<Person> ListAll() {
        List<Person> ListPerson = personRepository.findAll();

        ListPerson.forEach(person -> {
            person.setPhoneNumber(phoneNumberRepository.findAllByPerson(new Person(person.getId())));
            person.setAddressList(addressRepository.findAllByPerson(new Person(person.getId())));
        });
//        List<ListAddressDto> listAddress = addressRepository.findAllByPerson();
//        List<ListPersonDto> listPhoneNumber = phoneNumberRepository.findAllByPerson();
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
