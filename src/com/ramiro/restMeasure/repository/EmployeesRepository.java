package com.ramiro.restMeasure.repository;

import org.springframework.data.repository.CrudRepository;
import com.ramiro.restMeasure.entities.Employee;

public interface EmployeesRepository extends CrudRepository<Employee, Long> {
	 
}