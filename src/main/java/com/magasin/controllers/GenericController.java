package com.magasin.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import com.magasin.dto.ResponseDTO;
import com.magasin.exception.InvalidArgumentsException;
import com.magasin.service.GenericService;
import com.magasin.utils.TokenUtils;

import jakarta.validation.Valid;

public class GenericController<T> {
	@Autowired
	private GenericService<T> service;

	@PostMapping
	public ResponseEntity<ResponseDTO> create(@RequestPart(value = "files", required = false) MultipartFile[] files,
			@RequestPart("body") @Valid T dto) {
		String userIdString = TokenUtils.getFieldFromToken("userId");
		if (userIdString.isEmpty() || userIdString == null) {
			throw new InvalidArgumentsException("Invalid Token");
		}
		return new ResponseEntity(new ResponseDTO("Entity Created Successfully", this.service.create(files, dto)),
				HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<ResponseDTO> update(@RequestPart(value = "files", required = false) MultipartFile[] files,
			@RequestPart("body") @Valid T dto) {
		String userIdString = TokenUtils.getFieldFromToken("userId");
		if (userIdString.isEmpty() || userIdString == null) {
			throw new InvalidArgumentsException("Invalid Token");
		}
		return new ResponseEntity(new ResponseDTO("Entity Updated Successfully", this.service.update(files, dto)),
				HttpStatus.OK);
	}

	@DeleteMapping({ "/{id}" })
	public ResponseEntity<ResponseDTO> delete(@Valid @PathVariable long id) {
		String userIdString = TokenUtils.getFieldFromToken("userId");
		if (userIdString.isBlank() && userIdString.isEmpty()) {
			throw new InvalidArgumentsException("Invalid Token");
		}
		this.service.delete(id);
		return new ResponseEntity(new ResponseDTO("Entity Deleted Successfully", (Object) null), HttpStatus.OK);
	}

	@GetMapping({ "/{id}" })
	public ResponseEntity<ResponseDTO> get(@Valid @PathVariable long id) {
		String userIdString = TokenUtils.getFieldFromToken("userId");
		if (userIdString.isBlank() || userIdString.isEmpty()) {
			throw new InvalidArgumentsException("Invalid Token");
		}
		return new ResponseEntity(new ResponseDTO("Entity Found", this.service.read(id)), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<ResponseDTO> getAll() {
		String userIdString = TokenUtils.getFieldFromToken("userId");
		if (userIdString.isEmpty() || userIdString == null) {
			throw new InvalidArgumentsException("Invalid Token");
		}
		return new ResponseEntity(new ResponseDTO("Entity Found", this.service.readAll()), HttpStatus.OK);
	}
}