package com.kardbank.api.controller;

import com.kardbank.api.dto.phoneValidation.Phonevalidation;
import com.kardbank.api.service.PhonevalidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/phoneValidation")
public class PhoneValidation {


    @Autowired
    private PhonevalidationService phonevalidationService;

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<Phonevalidation> phoneValidation(@PathVariable String phoneNumber) {
        ResponseEntity<Phonevalidation> entity = phonevalidationService.phonevalidation(phoneNumber);
        return entity;
    }
}
