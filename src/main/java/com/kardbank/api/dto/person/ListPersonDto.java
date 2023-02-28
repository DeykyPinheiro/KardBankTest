package com.kardbank.api.dto.person;

import com.kardbank.api.model.person.Person;

import java.util.Date;

public record ListPersonDto(Long id, String name, String lastName, String email, Date birthDate) {
    public ListPersonDto(Person data) {
        this(data.getId(), data.getName(), data.getLastName(), data.getEmail(), data.getBirthDate());
    }
}
