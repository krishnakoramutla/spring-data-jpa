package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Employee;
import com.example.Service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> list = service.findAllEmployees();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/employees/{firstName}/{lastName}")
	public ResponseEntity<List<Employee>> getEmployeesByFirstNAmeLastName(@PathVariable String firstName,
			@PathVariable String lastName) {
		List<Employee> list = service.findByFirstNameLastName(firstName, lastName);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/employees/{firstName}")
	public ResponseEntity<List<Employee>> getEmployeesFirstNameLIke(@PathVariable String firstName) {
		List<Employee> list = service.findFirstNameLike(firstName);
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

}
