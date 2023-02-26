package com.kardbank.api.dto.user;

import com.kardbank.api.model.User;

import java.util.Date;

public record ListUserDto(Long id, String name, String lastName, String email, Date birthDate) {
    public ListUserDto(User data) {
        this(data.getId(), data.getName(), data.getLastName(), data.getEmail(), data.getBirthDate());
    }
}
