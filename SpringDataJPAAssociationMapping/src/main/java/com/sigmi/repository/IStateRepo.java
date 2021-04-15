package com.sigmi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sigmi.entity.State;

public interface IStateRepo extends JpaRepository<State, Integer> {

}
