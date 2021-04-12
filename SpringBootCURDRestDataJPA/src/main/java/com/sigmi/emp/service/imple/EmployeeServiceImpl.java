package com.sigmi.emp.service.imple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sigmi.emp.model.Employee;
import com.sigmi.emp.repo.EmployeeRepository;
import com.sigmi.emp.service.IEmployeeService;
@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;
	@Override
	public Integer saveEmployee(Employee e) {
		// TODO Auto-generated method stub
		return repo.save(e).getEId();
	}
	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}
	@Override
	public Optional<Employee> getOneEmployee(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}
	@Override
	public void deleteEmployee(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}
	@Override
	public boolean isExist(Integer id) {
		// TODO Auto-generated method stub
		return repo.existsById(id);
	}
	
}
