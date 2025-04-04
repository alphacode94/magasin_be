package com.magasin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magasin.models.MachineParts;

@Repository
public interface MachinePartRespository extends JpaRepository<MachineParts, Long> {

	List<MachineParts> findByMachine_MachineId(Long machineId);

}
