package com.kardbank.api.repository;

import com.kardbank.api.model.person.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;

public interface PersonRepository extends JpaRepository<Person, Long> {
    Page<Person> findAllByActiveTrue(Pageable page);

    Person findByEmail(String email);
}
