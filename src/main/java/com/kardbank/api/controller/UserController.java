package com.kardbank.api.controller;

import com.kardbank.api.dto.user.ListUserDto;
import com.kardbank.api.dto.user.SaveUserDto;
import com.kardbank.api.dto.user.UpdateUserDto;
import com.kardbank.api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    @Transactional
    public void saveUser(@RequestBody @Valid SaveUserDto user) throws Exception {
        userService.save(user);
    }

    @GetMapping
    public Page<ListUserDto> ListAll(@PageableDefault(size = 10, sort = {"name"}) Pageable page) {
        return userService.ListAll(page);
    }

    @PutMapping
    @Transactional
    public void updateUser(@RequestBody @Valid UpdateUserDto user){
        userService.update(user);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteUser(@PathVariable Long id){
        userService.delete(id);
    }
}
