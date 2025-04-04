package com.magasin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.magasin.dto.SupplierDTO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/api/supplier")
public class SupplierController extends GenericController<SupplierDTO> {

//	 @GetMapping({"/salutationType/{salutationType}"})
//	   public ResponseEntity<ResponseDTO> getClients(@PathVariable("salutationType") Integer salutationType, @RequestParam(value = "search",required = false) String search) {
//	      return new ResponseEntity(new ResponseDTO("Entity Found", this.salutationService.getSalutationByType(salutationType, search)), HttpStatus.OK);
//	   }
}
