package com.google.Springboot2.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.Springboot2.dto.Employee;
@RestController
@RequestMapping("/admins")
public class AdminController {
	@PostMapping
	public void insertData(@RequestBody Employee emp) {
		System.out.println(emp);
		System.out.println("Data Inserted Successfully");
	}
	@DeleteMapping("/id")
	public void deleteById() {
		System.out.println("Data deleted Successfully");
	}
	@DeleteMapping
	public void deleteAll() {
		System.out.println("All Data deleted Successfully");
	}
	@GetMapping
	public void fetchById() {
		System.out.println("Data fetched Successfully");
	}
	@PutMapping
	public void updateData() {
		System.out.println("Data updated Successfully");
	}


}
