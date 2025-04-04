package com.magasin.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magasin.models.Clients;

@Repository
public interface ClientRespository extends JpaRepository<Clients, Long> {
	Optional<Clients> findByClientNameIgnoreCase(String ClientName);

}
