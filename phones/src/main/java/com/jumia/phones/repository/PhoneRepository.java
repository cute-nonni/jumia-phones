package com.jumia.phones.repository;

import com.jumia.phones.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface PhoneRepository extends JpaRepository<Customer, Integer> {
}
