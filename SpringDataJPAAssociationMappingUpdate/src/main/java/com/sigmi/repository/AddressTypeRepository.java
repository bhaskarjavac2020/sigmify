package com.sigmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigmi.entity.AddressType;

public interface AddressTypeRepository extends JpaRepository<AddressType, Integer> {
  public AddressType findByName(String name);
}
