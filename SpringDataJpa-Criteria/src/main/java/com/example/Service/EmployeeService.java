package com.example.Service;

import java.util.List;

import com.example.Model.Employee;

public interface EmployeeService {

	public List<Employee> findAllEmployees();

	public Employee addEmployee(Employee employee);

	public List<Employee> findByFirstNameLastName(String firstName, String lastName);

	public List<Employee> findFirstNameLike(String firstName);

}
