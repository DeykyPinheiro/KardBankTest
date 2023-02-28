package com.kardbank.api.dto.addressDto;

import jakarta.validation.constraints.NotNull;

public record UpdateAddressDto(
        @NotNull
        long id,

        String street,

        String number
) {
}
