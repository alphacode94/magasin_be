package com.magasin.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.magasin.dto.MachineDTO;
import com.magasin.dto.MachinePartDTO;
import com.magasin.dto.ResponseDTO;
import com.magasin.service.MachinePartService;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/api/machine")
public class MachineController extends GenericController<MachineDTO> {
	@Autowired
	MachinePartService mpservice;

	@Transactional
	@PostMapping(value = "/parts")
	public ResponseEntity<ResponseDTO> addParts(MachinePartDTO dto) throws Exception {
		ResponseDTO responseDTO = new ResponseDTO();
		MachinePartDTO res = mpservice.create(null, dto);

		responseDTO = new ResponseDTO("Entity created", res);
		return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);

	}

	@Transactional
	@PutMapping(value = "/parts")
	public ResponseEntity<ResponseDTO> updateParts(MachinePartDTO dto) throws Exception {
		ResponseDTO responseDTO = new ResponseDTO();
		MachinePartDTO res = mpservice.update(null, dto);

		responseDTO = new ResponseDTO("Entity updated", res);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);

	}

	@Transactional
	@GetMapping(value = "/parts/{id}")
	public ResponseEntity<ResponseDTO> getPartById(@RequestParam Long id) throws Exception {
		ResponseDTO responseDTO = new ResponseDTO();
		MachinePartDTO res = mpservice.read(id);

		responseDTO = new ResponseDTO("Entity Found", res);
		return new ResponseEntity<>(responseDTO, HttpStatus.FOUND);

	}

	@Transactional
	@GetMapping(value = "/parts")
	public ResponseEntity<ResponseDTO> getAllPart() throws Exception {
		ResponseDTO responseDTO = new ResponseDTO();
		List<MachinePartDTO> res = mpservice.readAll();

		responseDTO = new ResponseDTO("Data Found", res);
		return new ResponseEntity<>(responseDTO, HttpStatus.OK);

	}

}
