package com.kardbank.api.model.address;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.kardbank.api.dto.addressDto.SaveAddressDto;
import com.kardbank.api.dto.addressDto.UpdateAddressDto;
import com.kardbank.api.model.person.Person;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnoreProperties("address")
    private Person person;

    private String street;

    private String number;

    public Address(Person person, SaveAddressDto data) {
        this.person = person;
        this.street = data.street();
        this.number = data.number();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(person, address.person) &&
                Objects.equals(street, address.street) &&
                Objects.equals(number, address.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, street, number);
    }

    public void update(UpdateAddressDto data) {
        if (data.number() != null) {
            this.number = data.number();
        }
        if (data.street() != null) {
            this.street = data.street();
        }

    }

}
