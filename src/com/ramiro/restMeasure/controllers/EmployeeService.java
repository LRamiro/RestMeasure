package com.ramiro.restMeasure.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ramiro.restMeasure.entities.Employee;
import com.ramiro.restMeasure.repository.EmployeesRepository;

@RestController
public class EmployeeService {
	
	@Autowired
	private EmployeesRepository employeesRepository;
	
	private Map<Integer, Employee> employees;

	public EmployeeService() {
		employees = new HashMap<>();
	}

	@PutMapping("/put/{idEmployee}")
	public Employee putEmployee(@PathVariable int idPersona, @RequestBody Employee employee){ 
		Employee employ = new Employee(new Long(idPersona), employee.getNombre(), employee.getApellido());
	  employeesRepository.save(employ);
	  return employ;
	 }

	@GetMapping("/get")
	public Employee getEmployee(@RequestParam("idEmployee") int idEmployee) {
		return employees.get(idEmployee);
	}

	@PostMapping("/post")
	public Employee postEmployee(@RequestBody Employee employee) {
		Random r = new Random();
		employees.put(r.nextInt(), employee);
		return employee;
	}

	@DeleteMapping("/delete/{idEmployee}")
	public String deleteEmployee(@PathVariable int idEmployee) {
		try {
			employees.remove(idEmployee);
		} catch (Exception e) {
			return "Error";
		}
		return "Listo";
	}

}
