package com.sigmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigmi.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
