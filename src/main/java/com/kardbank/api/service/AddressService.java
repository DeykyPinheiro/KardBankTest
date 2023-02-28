package com.kardbank.api.service;


import com.kardbank.api.dto.addressDto.ListAddressDto;
import com.kardbank.api.dto.addressDto.SaveAddressDto;
import com.kardbank.api.dto.addressDto.UpdateAddressDto;
import com.kardbank.api.dto.person.UpdatePersonDto;
import com.kardbank.api.model.address.Address;
import com.kardbank.api.model.person.Person;
import com.kardbank.api.repository.AddressRepository;
import com.kardbank.api.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private PersonRepository personRepository;

    public void save(SaveAddressDto data) throws Exception {
//        verificar se o user existe
        Optional<Person> p = personRepository.findById(data.idPerson());
        Person person = p.orElseThrow(() -> new RuntimeException("Usuario não existente!"));

//        endereco que recebi no data
        Address address = new Address(person, data);

//        verificacaoes para nao incluir repetido
        List<Address> addressList = addressRepository.findAllByPerson(person);
        if (addressList.size() < 1) {
            addressRepository.save(address);
        }

        boolean isAddressRegistered = false;

        for (Address item : addressList) {
            if (item.equals(address)) {
                isAddressRegistered = true;
            }
        }
        if (!isAddressRegistered){
            addressRepository.save(address);
        }
    }

    public List<ListAddressDto> listAllByPerson(Long idPerson) {
        List<ListAddressDto> listAddress = addressRepository.findAllByPerson(new Person(idPerson)).stream().map(ListAddressDto::new).collect(Collectors.toList());
        return listAddress;
    }

    public void update(UpdateAddressDto address) {
        Address old = addressRepository.getReferenceById(address.id());
        old.update(address);
    }

    public void delete(Long id) {
        Address address = addressRepository.getReferenceById(id);
        addressRepository.delete(address);
    }
}



