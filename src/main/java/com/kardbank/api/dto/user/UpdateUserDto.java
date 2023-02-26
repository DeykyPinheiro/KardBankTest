package com.kardbank.api.dto.user;

import com.kardbank.api.model.User;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;


public record UpdateUserDto(
        @NotNull
        Long id,

        String name,

        String lastName,

        Date birthDate,

        Boolean active
) {
}
