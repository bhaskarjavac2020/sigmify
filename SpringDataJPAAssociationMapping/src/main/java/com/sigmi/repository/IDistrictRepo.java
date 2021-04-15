package com.sigmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigmi.entity.District;

public interface IDistrictRepo extends JpaRepository<District, Integer> {

}
