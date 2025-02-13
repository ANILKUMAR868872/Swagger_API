package com.example.Kumar.repo;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Kumar.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	// No need to define methods like save(), findAll(), deleteById() because they are inherited from JpaRepository



}
