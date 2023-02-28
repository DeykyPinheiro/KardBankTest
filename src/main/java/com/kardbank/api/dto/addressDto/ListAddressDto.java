package com.kardbank.api.dto.addressDto;

import com.kardbank.api.model.address.Address;
import com.kardbank.api.model.person.Person;

public record ListAddressDto(Long id, String street, String number) {

    public ListAddressDto(Address data) {
        this(data.getId(), data.getStreet(), data.getNumber());
    }
}
