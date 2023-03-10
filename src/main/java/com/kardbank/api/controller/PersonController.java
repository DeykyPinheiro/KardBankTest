package com.kardbank.api.controller;

import com.kardbank.api.dto.person.ListPersonDto;
import com.kardbank.api.dto.person.SavePersonDto;
import com.kardbank.api.dto.person.UpdatePersonDto;
import com.kardbank.api.model.person.Person;
import com.kardbank.api.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @Transactional
    public void savePerson(@RequestBody @Valid SavePersonDto person) throws Exception {
        personService.save(person);
    }

    @GetMapping
    public List<Person> ListAll() {
        return personService.ListAll();
    }

    @PutMapping
    @Transactional
    public void updatePerson(@RequestBody @Valid UpdatePersonDto person) {
        personService.update(person);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletePerson(@PathVariable Long id) {
        personService.delete(id);
    }
}
