package com.kardbank.api.repository;

import com.kardbank.api.model.address.Address;
import com.kardbank.api.model.person.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    List<Address> findAllByPerson(Person person);
}
