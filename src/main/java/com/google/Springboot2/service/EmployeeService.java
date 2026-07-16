package com.google.Springboot2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.google.Springboot2.dao.EmployeeDao;
import com.google.Springboot2.dto.Employee;
import com.google.Springboot2.repository.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	EmployeeRepository employeeRepository;
	
	
	public String insertData(Employee employee) {
		return employeeDao.insertData(employee);
  }
	
	
	public Object fetchById(int id) {
	Optional<Employee>oe=employeeDao.fetchById(id);
	if(oe.isPresent()) {
		return oe.get();
		}
	else
		return "no data found with id"+id;
	}

	
	
	
	public Object fetchAll() {
		List<Employee> l= employeeDao.fetchAll();
		if(l.isEmpty()) {
			return "no data found";
			}
		else
			return l;
	}
	
	
	
	public String deleteAll() {
		List<Employee> l=employeeDao.fetchAll();
		if(l.isEmpty()) {
			return "no data found";
		}
		else
			employeeRepository.deleteAll();
		
		return "data deleted";
	}
	
	
	
	public String deleteById(int id) {
		Optional<Employee> oe=employeeDao.fetchById(id);
		if(oe.isPresent()) {
			employeeRepository.deleteById(id);
			return "data deleted";
		}
		else
			return "no data found";
	}
	
	
	
	
	public String update( Employee employee) {
		return employeeDao.update(employee);
		
	}
	
	
	public String insertAllData(List<Employee> employee) {
		return employeeDao.insertAllData(employee);
		
	}
	
	public Page<Employee> fetchALLEmployee( int pageNumber, int Size){
		PageRequest of=PageRequest.of(pageNumber, Size,Sort.by("name"));
		return employeeRepository.findAll(of);

	}
	public List<Employee> getEmployeeByName(String name) {
	    return employeeRepository.findByName(name);
	}
	
}
