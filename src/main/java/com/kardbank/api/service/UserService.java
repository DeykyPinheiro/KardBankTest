package com.kardbank.api.service;

import com.kardbank.api.dto.user.ListUserDto;
import com.kardbank.api.dto.user.UpdateUserDto;
import com.kardbank.api.model.User;
import com.kardbank.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.kardbank.api.dto.user.SaveUserDto;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void save(SaveUserDto data) throws Exception {

        User old = userRepository.findByEmail(data.email());
        if (old != null) {
            throw  new Exception("Usuario Ja Cadastrado");
        } else {
            User user = new User(data);
            userRepository.save(user);
        }
    }

    public Page<ListUserDto> ListAll(Pageable page) {
        Page ListUser = userRepository.findAllByActiveTrue(page).map(ListUserDto::new);
        return ListUser;
    }

    public void update(UpdateUserDto user) {
        User old = userRepository.getReferenceById(user.id());
        old.update(user);
    }

    public void delete(Long id) {
        User old = userRepository.getReferenceById(id);
        old.delete();
    }

}
