package com.example.Specification;

import javax.persistence.criteria.CriteriaQuery;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import com.example.Model.Employee;
import com.example.Model.Employee_;
@Component
public class EmployeeSpecification {
	
	public static Specification<Employee> hasFirstName(String firstName){
		
		return ((root,criteriaQuery,criteriaBuilder)->{
		return criteriaBuilder.equal(root.get(Employee_.FIRST_NAME), firstName);
	});
		
	}
	
public static Specification<Employee> hasLastName(String lastName){
		
		return ((root,criteriaQuery,criteriaBuilder)->{
		return criteriaBuilder.equal(root.get(Employee_.LAST_NAME), lastName);
	});
		
	}

public static Specification<Employee> containsLastName(String lastName){
	
	return ((root,criteriaQuery,criteriaBuilder)->{
	return criteriaBuilder.like(root.get(Employee_.LAST_NAME), "%"+lastName+"%");
});
	
}
	
	
}
