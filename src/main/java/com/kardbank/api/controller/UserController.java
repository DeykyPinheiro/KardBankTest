package com.kardbank.api.controller;

import com.kardbank.api.dto.user.ListUserDto;
import com.kardbank.api.dto.user.SaveUserDto;
import com.kardbank.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public void saveUser(@RequestBody @Valid SaveUserDto user) {
        userService.save(user);
    }

    @GetMapping
    public Page<ListUserDto> ListAll(@PageableDefault(size = 10, sort = {"name"}) Pageable page) {
        return userService.ListAll(page);
    }
}
