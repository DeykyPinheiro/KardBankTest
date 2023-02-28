package com.kardbank.api.model.person;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kardbank.api.dto.person.SavePersonDto;
import com.kardbank.api.dto.person.UpdatePersonDto;
import com.kardbank.api.dto.phoneNumber.PhoneNumberDto;
import com.kardbank.api.model.address.Address;
import com.kardbank.api.model.phoneNumber.PhoneNumber;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "person", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("person")
    private List<Address> addressList;

    @OneToMany(mappedBy = "person", cascade = CascadeType.REMOVE)
    @JsonIgnoreProperties("person")
    private List<PhoneNumber> phoneNumber;


    private String name;

    private String lastName;

    private String email;

    private Date birthDate;

    private String cpf;

    private boolean active;


    public Person(SavePersonDto data) {
        this.active = true;
        this.name = data.name();
        this.lastName = data.lastName();
        this.email = data.email();
        this.birthDate = data.birthDate();
        this.cpf = data.cpf();
    }

    public Person(Long idPerson) {
        this.id = idPerson;
    }


    public void update(UpdatePersonDto data) {

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
