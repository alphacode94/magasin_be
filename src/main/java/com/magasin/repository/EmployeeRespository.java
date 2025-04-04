package com.magasin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magasin.models.Employee;

@Repository
public interface EmployeeRespository extends JpaRepository<Employee, Long> {
	Optional<Employee> findByNomIgnoreCase(String nom);
}
