package com.kardbank.api.repository;

import com.kardbank.api.model.phoneNumber.PhoneNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneNumberRepository extends JpaRepository<PhoneNumber, Long> {
}
