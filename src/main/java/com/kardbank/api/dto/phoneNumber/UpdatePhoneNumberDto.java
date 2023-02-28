package com.kardbank.api.dto.phoneNumber;

import com.kardbank.api.model.person.Person;
import jakarta.validation.constraints.NotNull;

public record UpdatePhoneNumberDto(
        @NotNull Long id,
        String phoneNumber
) {
}
