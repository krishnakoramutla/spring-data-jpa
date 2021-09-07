package com.example.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Model.Employee;
import com.example.Repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repository;

	@Override
	public List<Employee> findAllEmployees() {

		return repository.findAll();
	}

	@Override
	public Employee addEmployee(Employee employee) {

		return repository.save(employee);
	}

	@Override
	public List<Employee> findByFirstNameLastName(String firstName, String lastName) {

		return repository.findByFirstNameAndLastName(firstName, lastName);
	}

	@Override
	public List<Employee> findFirstNameLike(String firstName) {
		//
		return repository.findFirstNameLike(firstName);
	}

}
