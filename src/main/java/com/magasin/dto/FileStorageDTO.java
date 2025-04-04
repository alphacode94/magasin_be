package com.magasin.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class FileStorageDTO {
	private Long fileId;
	private String documentId;
	private String fileUrl;
	private String originalName;
	private String contentType;
	private String notes;
	private Boolean isDiscontinued;
}
