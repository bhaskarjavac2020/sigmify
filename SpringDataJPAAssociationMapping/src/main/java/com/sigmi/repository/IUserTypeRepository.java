package com.sigmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigmi.entity.UserType;

public interface IUserTypeRepository extends JpaRepository<UserType, Integer> {
 public UserType findByName(String name);
}
