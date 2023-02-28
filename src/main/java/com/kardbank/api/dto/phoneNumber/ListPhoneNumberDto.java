package com.kardbank.api.dto.phoneNumber;


import com.kardbank.api.model.address.Address;
import com.kardbank.api.model.phoneNumber.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ListPhoneNumberDto(
        Long id,

        String phoneNumber

) {
    public ListPhoneNumberDto(PhoneNumber data) {
        this(data.getId(), data.getPhoneNumber());
    }
}
