package com.kardbank.api.model.phoneNumber;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kardbank.api.dto.phoneNumber.PhoneNumberDto;
import com.kardbank.api.model.person.Person;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("address")
    private Person person;

    private String phone;


    public PhoneNumber(PhoneNumberDto phone) {
//        this.person = new Person(phone.id())
        this.phone = phone.phone();
    }


}