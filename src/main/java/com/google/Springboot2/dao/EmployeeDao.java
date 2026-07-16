package com.google.Springboot2.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.Springboot2.dto.Employee;
import com.google.Springboot2.repository.EmployeeRepository;
@Repository
public class EmployeeDao {
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public String insertData(Employee employee) {
		employeeRepository.save(employee);
		return "data inserted";
	}
	
	
public Optional<Employee> fetchById(int id) {
	Optional<Employee> oe=employeeRepository.findById(id);
	return oe;
}


	public List<Employee> fetchAll() {
	     return employeeRepository.findAll();
	    
	}
//	public String DeleteById(int id) {
//		employeeRepository.deleteById(id);
//		return "data deleted";
//	}
//	public String deleteAll() {
//		employeeRepository.deleteAll();
//		return "data deleted";
//	}
	
	
	public String update(Employee employee) {
		employeeRepository.save(employee);
		return "data updated successfully";
		
	}
	
	
	public String insertAllData(List<Employee>employee) {
		employeeRepository.saveAll(employee);
		return "all data inserted successfully";
		
	}
}

