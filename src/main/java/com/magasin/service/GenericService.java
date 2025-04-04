package com.magasin.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface GenericService<T> {
	T create(MultipartFile[] files, T dto);

	T read(long id);

	List<T> readAll();

	T update(MultipartFile[] files, T dto);

	void delete(long id);
}