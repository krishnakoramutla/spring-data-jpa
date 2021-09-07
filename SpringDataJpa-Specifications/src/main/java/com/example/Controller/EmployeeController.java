package com.example.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Employee;
import com.example.Repository.EmployeeRepository;
import com.example.Service.EmployeeService;
import com.example.Specification.EmployeeSpecification;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	@Autowired
	private EmployeeRepository repository;

	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getEmployees() {
		List<Employee> list = service.findAllEmployees();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	@GetMapping("/employees/{firstName}/{lastName}")
	public ResponseEntity<List<Employee>> getEmployeesByFirstNAmeLastName(@PathVariable String firstName,
			@PathVariable String lastName) {
	
		Specification<Employee> specification=Specification.where(EmployeeSpecification.hasFirstName(firstName).and(EmployeeSpecification.hasLastName(lastName)));
		
		
		return new ResponseEntity<>(repository.findAll(specification),HttpStatus.OK);
	}
		

	@GetMapping("/employees/{lastName}")
	public ResponseEntity<List<Employee>> getEmployeesFirstNameLIke(@PathVariable String lastName) {
		
		Specification<Employee> specification=
				Specification.where(EmployeeSpecification.containsLastName(lastName));
		
		
		return new ResponseEntity<>(repository.findAll(specification),HttpStatus.OK);

			}

}
