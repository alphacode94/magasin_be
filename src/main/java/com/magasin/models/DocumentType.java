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
@Table(name = "document_type")
public class DocumentType extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DocumentType")
	private Long documentType; // Assuming it's an ID field

	@Column(name = "DocumentDescription", nullable = false)
	private String documentDescription;

	@Column(name = "DocumentCode", unique = true, nullable = false)
	private String documentCode;

	@Column(name = "LinkDocumentType")
	private String linkDocumentType;

	@Column(name = "DocumentFolderPath")
	private String documentFolderPath;

	@Column(name = "IsDiscontinued")
	private Boolean isDiscontinued;

}
