package com.kardbank.api.controller;


import com.kardbank.api.dto.addressDto.ListAddressDto;
import com.kardbank.api.dto.addressDto.UpdateAddressDto;
import com.kardbank.api.dto.person.SavePersonDto;
import com.kardbank.api.dto.phoneNumber.ListPhoneNumberDto;
import com.kardbank.api.dto.phoneNumber.SavePhoneNumberDto;
import com.kardbank.api.dto.phoneNumber.UpdatePhoneNumberDto;
import com.kardbank.api.service.AddressService;
import com.kardbank.api.service.PhoneNumberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phoneNumber")
public class PhoneNumber {

    @Autowired
    private PhoneNumberService phoneNumberService;

    @PostMapping
    @Transactional
    public void savePhoneNumber(@RequestBody @Valid SavePhoneNumberDto phone) throws Exception {
        phoneNumberService.save(phone);
    }

    @GetMapping("/{id}")
    public List<ListPhoneNumberDto> listAllByPerson(@PathVariable Long id) {
        List<ListPhoneNumberDto> listPhoneNumber = phoneNumberService.listAllByPerson(id);
        return listPhoneNumber;
    }

    @PutMapping
    @Transactional
    public void updatePhoneNumber(@RequestBody @Valid UpdatePhoneNumberDto phone) {
        phoneNumberService.update(phone);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        phoneNumberService.delete(id);
    }




}
