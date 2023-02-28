package com.kardbank.api.repository;

import com.kardbank.api.model.address.Address;
import com.kardbank.api.model.person.Person;
import com.kardbank.api.model.phoneNumber.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
    PhoneNumber findByPhoneNumber(String phoneNumber);

    List<PhoneNumber> findAllByPerson(Person person);
}
