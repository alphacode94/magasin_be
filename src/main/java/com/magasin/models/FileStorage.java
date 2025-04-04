package com.magasin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "FileStorage")
public class FileStorage extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Fileid")
	private Long fileId;

	@Column(name = "documentId", nullable = false) // This will store Employee's documentId
	private String documentId;

	@Column(name = "FileUrl", nullable = false)
	private String fileUrl;

	@Column(name = "OriginalName")
	private String originalName;

	@Column(name = "ContentType")
	private String contentType;

	@Column(name = "Notes")
	private String notes;

	@Column(name = "IsDiscontinued")
	private Boolean isDiscontinued;
}
