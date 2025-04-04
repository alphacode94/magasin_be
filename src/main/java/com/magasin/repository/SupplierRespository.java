package com.magasin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magasin.models.Supplier;

@Repository
public interface SupplierRespository extends JpaRepository<Supplier, Long> {
	Optional<Supplier> findBySupplierNameIgnoreCase(String SupplierName);

}
