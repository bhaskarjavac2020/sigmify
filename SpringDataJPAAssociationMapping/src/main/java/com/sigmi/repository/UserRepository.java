package com.sigmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigmi.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	void deleteByUtype(Integer id);
}
