package com.magasin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magasin.models.Machine;

@Repository
public interface MachineRespository extends JpaRepository<Machine, Long> {

}
