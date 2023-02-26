package com.kardbank.api.model;

import com.kardbank.api.dto.user.SaveUserDto;
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


    public User(SaveUserDto data){
        this.name = data.name();
        this.lastName = data.lastName();
        this.email = data.email();
        this.birthDate = data.birthDate();
    }
}
