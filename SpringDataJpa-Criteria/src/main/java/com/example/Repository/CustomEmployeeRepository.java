package com.example.Repository;

import java.util.List;

import com.example.Model.Employee;

public interface CustomEmployeeRepository {
	public List<Employee> findByFirstNameAndLastName(String firstName, String lastName);

	public List<Employee> findFirstNameLike(String firstName);

}
