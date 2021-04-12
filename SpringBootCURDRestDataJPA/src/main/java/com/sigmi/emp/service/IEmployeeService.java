package com.sigmi.emp.service;

import java.util.List;
import java.util.Optional;

import com.sigmi.emp.model.Employee;

public interface IEmployeeService {
	public Integer saveEmployee(Employee e);
    public List<Employee> getAllEmployees();
	public Optional<Employee> getOneEmployee(Integer id);
	public void deleteEmployee(Integer id);
	public boolean isExist(Integer id);
}
