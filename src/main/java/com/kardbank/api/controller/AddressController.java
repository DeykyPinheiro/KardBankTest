package com.kardbank.api.controller;

import com.kardbank.api.dto.addressDto.ListAddressDto;
import com.kardbank.api.dto.addressDto.SaveAddressDto;
import com.kardbank.api.dto.addressDto.UpdateAddressDto;
import com.kardbank.api.dto.person.ListPersonDto;
import com.kardbank.api.dto.person.SavePersonDto;
import com.kardbank.api.dto.person.UpdatePersonDto;
import com.kardbank.api.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping
    @Transactional
    public void saveAddress(@RequestBody @Valid SaveAddressDto address) throws Exception {
        addressService.save(address);
    }
    @GetMapping("/{id}")
    public List<ListAddressDto> listAllByPerson(@PathVariable Long id) {
        List<ListAddressDto> listAddressbyPerson = addressService.listAllByPerson(id);
        return listAddressbyPerson;
    }

    @PutMapping
    @Transactional
    public void updateAddress(@RequestBody @Valid UpdateAddressDto address) {
        addressService.update(address);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
         addressService.delete(id);
    }

}
