package com.kardbank.api.service;

import com.kardbank.api.dto.user.ListUserDto;
import com.kardbank.api.model.User;
import com.kardbank.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.kardbank.api.dto.user.SaveUserDto;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(SaveUserDto data) {
        User user = new User(data);
        userRepository.save(user);
    }

    public Page<ListUserDto> ListAll(Pageable page) {
        Page ListUser = userRepository.findAll(page).map(ListUserDto::new);
        return ListUser;
    }

}
