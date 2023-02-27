package com.kardbank.api.dto.person;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record SavePersonDto(
        @NotBlank String name,

        @NotBlank String lastName,

        @NotBlank @Email String email,

        @NotNull Date birthDate) {
}
