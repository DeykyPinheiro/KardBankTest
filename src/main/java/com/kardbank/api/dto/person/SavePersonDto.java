package com.kardbank.api.dto.person;

import com.kardbank.api.dto.addressDto.SaveAddressDto;
import com.kardbank.api.model.address.Address;
import com.kardbank.api.model.phoneNumber.PhoneNumber;
import jakarta.validation.constraints.*;

import java.util.Date;
import java.util.List;

public record SavePersonDto(
        @NotBlank String name,

        @NotBlank String lastName,

        @NotNull Date birthDate,

        @NotBlank String cpf,

        @NotBlank @Email String email

) {
}
