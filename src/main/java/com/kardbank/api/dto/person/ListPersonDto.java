package com.kardbank.api.dto.person;

import com.kardbank.api.dto.addressDto.ListAddressDto;
import com.kardbank.api.dto.phoneNumber.ListPhoneNumberDto;
import com.kardbank.api.model.person.Person;

import java.util.Date;
import java.util.List;

public record ListPersonDto(Long id, String name, String lastName, String email, Date birthDate
) {
    public ListPersonDto(Person data) {
        this(data.getId(), data.getName(), data.getLastName(), data.getEmail(), data.getBirthDate());
    }
}
