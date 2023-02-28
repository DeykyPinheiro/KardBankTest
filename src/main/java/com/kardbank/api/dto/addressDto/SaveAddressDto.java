package com.kardbank.api.dto.addressDto;

import com.kardbank.api.dto.person.SavePersonDto;
import com.kardbank.api.model.person.Person;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SaveAddressDto(
        @NotNull Long idPerson,
        @NotBlank String street,
        @NotBlank String number) {

}
