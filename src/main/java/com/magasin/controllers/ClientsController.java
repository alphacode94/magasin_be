package com.magasin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.magasin.dto.ClientDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/api/clients")
public class ClientsController extends GenericController<ClientDTO> {

	/*
	 * @PostMapping({ "/machine" }) public ResponseEntity<ResponseDTO>
	 * addMachine(@RequestBody MachineDTO dto) {
	 * 
	 * MachineDTO mDTO=new MachineDTO();
	 * 
	 * return new ResponseEntity(new ResponseDTO("Entity Found",)HttpStatus.OK); }
	 */
}
