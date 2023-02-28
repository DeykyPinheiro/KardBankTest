package com.kardbank.api.dto.phoneNumber;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SavePhoneNumberDto(
        @NotNull Long idPerson,

        @NotBlank String phoneNumber) {
}
