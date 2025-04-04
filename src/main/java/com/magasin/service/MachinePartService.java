package com.magasin.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.magasin.dto.MachinePartDTO;

@Service
public interface MachinePartService extends GenericService<MachinePartDTO> {

	List<MachinePartDTO> readAllByMachineId(Long id);

}
