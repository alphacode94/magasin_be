package com.magasin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magasin.models.EmployeeAdvance;

@Repository
public interface EmployeeAdvanceRespository extends JpaRepository<EmployeeAdvance, Long> {
	Optional<EmployeeAdvance> findByEmployeeEmpId(Long empId);
}
