package com.magasin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.magasin.models.FileStorage;

@Repository
public interface FileStorageRespository extends JpaRepository<FileStorage, Long> {

	List<FileStorage> findByDocumentId(String id);

}
