package com.sigmi.emp.repo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sigmi.emp.model.Employee;
public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
}
