package com.kardbank.api.dto.person;

import jakarta.validation.constraints.NotNull;

import java.util.Date;


public record UpdatePersonDto(
        @NotNull
        Long id,

        String name,

        String lastName,

        Date birthDate,

        Boolean active
) {
}
