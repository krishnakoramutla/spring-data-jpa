package com.example.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Model.Employee;
import com.example.Model.Employee_;

public class CustomEmployeeRepositoryImpl implements CustomEmployeeRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	public List<Employee> findByFirstNameAndLastName(String firstName, String lastName) {

		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

		Root<Employee> employee = cq.from(Employee.class);

//         //normal way
//		Predicate firstNamePredicate = cb.equal(employee.get("firstName"), firstName);
//		Predicate lastNamePredicate = cb.equal(employee.get("lastName"), lastName);

		// using jpa meta model classes. it required dependency hibernate-jpamodelgen.
		// usefull for handle compile time errors
		Predicate firstNamePredicate = cb.equal(employee.get(Employee_.FIRST_NAME), firstName);
		Predicate lastNamePredicate = cb.equal(employee.get(Employee_.LAST_NAME), lastName);

		cq.where(firstNamePredicate, lastNamePredicate);

		TypedQuery<Employee> query = entityManager.createQuery(cq);

		return query.getResultList();
	}

	@Override
	public List<Employee> findFirstNameLike(String firstName) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

		Root<Employee> employee = cq.from(Employee.class);

		Predicate frstNameLIkePredicate = cb.like(employee.get("firstName"), "%" + firstName + "%");
		cq.where(frstNameLIkePredicate);
		TypedQuery<Employee> query = entityManager.createQuery(cq);
		return query.getResultList();

	}

}
