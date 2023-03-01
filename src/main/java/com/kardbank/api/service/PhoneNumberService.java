package com.kardbank.api.service;

import com.kardbank.api.dto.phoneNumber.ListPhoneNumberDto;
import com.kardbank.api.dto.phoneNumber.SavePhoneNumberDto;
import com.kardbank.api.dto.phoneNumber.UpdatePhoneNumberDto;
import com.kardbank.api.model.address.Address;
import com.kardbank.api.model.person.Person;
import com.kardbank.api.model.phoneNumber.PhoneNumber;
import com.kardbank.api.repository.PhoneNumberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PhoneNumberService {

    @Autowired
    private PhoneNumberRepository phoneNumberRepository;

    @Autowired
    private PhonevalidationService phonevalidationService;


    public void save(SavePhoneNumberDto data) throws Exception {
//        System.out.println(data);

        var isValidNumber = phonevalidationService.phonevalidation(data.phoneNumber()).getBody().valid();
        if (!isValidNumber) {
            throw new Exception("Celular invalido");
        }

        PhoneNumber old = phoneNumberRepository.findByPhoneNumber(data.phoneNumber());
        if (old != null) {
            throw new Exception("Celular Ja Cadastrado");
        } else {
            PhoneNumber phone = new PhoneNumber(data);
            phoneNumberRepository.save(phone);
        }
    }

    public List<ListPhoneNumberDto> listAllByPerson(Long id) {
        List<ListPhoneNumberDto> listPhoneNumber = phoneNumberRepository.findAllByPerson(new Person(id))
                .stream().map(ListPhoneNumberDto::new).collect(Collectors.toList());
        return listPhoneNumber;
    }

    public void update(UpdatePhoneNumberDto phone) throws Exception {
        var isValidNumber = phonevalidationService.phonevalidation(phone.phoneNumber()).getBody().valid();
        if (!isValidNumber) {
            throw new Exception("Celular invalido");
        }
        PhoneNumber old = phoneNumberRepository.getReferenceById(phone.id());
        old.update(phone);
    }

    public void delete(Long id) {
        PhoneNumber phone = phoneNumberRepository.getReferenceById(id);
        phoneNumberRepository.delete(phone);
    }


}
