package com.kardbank.api.model.phoneNumber;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kardbank.api.dto.phoneNumber.SavePhoneNumberDto;
import com.kardbank.api.dto.phoneNumber.UpdatePhoneNumberDto;
import com.kardbank.api.model.person.Person;
import jakarta.persistence.*;
import lombok.*;

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

    private String phoneNumber;

    public PhoneNumber(SavePhoneNumberDto data) {
        this.person = new Person(data.idPerson());
        this.phoneNumber = data.phoneNumber();
    }

    public void update(UpdatePhoneNumberDto data) {
        if (data.phoneNumber() != null) {
            this.phoneNumber = data.phoneNumber();
        }
    }


}