package com.google.Springboot2.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.Springboot2.dto.Employee;
import com.google.Springboot2.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService employeeService;
	
	@PostMapping
	public String insertData(@RequestBody Employee employee) {
		return employeeService.insertData(employee);
		
	}
	
	@GetMapping(params ="id")
	public Object fetchById(@RequestParam int id) {
    	return employeeService.fetchById(id);
	}

	
@GetMapping	
	public Object fetchAll() {
	  return employeeService.fetchAll();
	}


@DeleteMapping("/{id}")
public String deleteById(@PathVariable int id) {
   return employeeService.deleteById(id);
   
}

@DeleteMapping
public String deleteAll() {
	return employeeService.deleteAll();
}


@PostMapping("/all")
public String insertAllData(@RequestBody List<Employee> employee) {
	return employeeService.insertAllData(employee);
	
}


@PatchMapping
public String update(@RequestBody Employee employee) {
	return employeeService.update(employee);
	
}
@GetMapping("/page/{pageNumber}/{Size}")
public Page<Employee> fetchALLEmployee(@PathVariable int pageNumber,@PathVariable int Size) {
	return employeeService.fetchALLEmployee(pageNumber, Size);

}
@GetMapping("/name/{name}")
public List<Employee> getEmployeeByName(@PathVariable String name) {
    return employeeService.getEmployeeByName(name);
}
}
