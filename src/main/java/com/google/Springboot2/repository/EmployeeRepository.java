package com.google.Springboot2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.google.Springboot2.dto.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	 List<Employee> findByName(String name);
}
