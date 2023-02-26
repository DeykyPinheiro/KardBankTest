package com.kardbank.api.model;

import com.kardbank.api.dto.user.SaveUserDto;
import com.kardbank.api.dto.user.UpdateUserDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String lastName;

    private String email;

    private Date birthDate;


    private boolean active;


    public User(SaveUserDto data) {
        this.active = true;
        this.name = data.name();
        this.lastName = data.lastName();
        this.email = data.email();
        this.birthDate = data.birthDate();
    }

    public void update(UpdateUserDto data) {

        if (data.name() != null) {
            this.name = data.name();
        }
        if (data.lastName() != null) {
            this.lastName = data.lastName();
        }

        if (data.birthDate() != null) {
            this.birthDate = data.birthDate();
        }

        if (data.active() != null) {
            this.active = data.active();
        }
    }

    public void delete() {
        this.active = false;
    }
}
