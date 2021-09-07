package com.example.Service;

import java.util.List;

import com.example.Model.Employee;

public interface EmployeeService {

	public List<Employee> findAllEmployees();

	public Employee addEmployee(Employee employee);


}
