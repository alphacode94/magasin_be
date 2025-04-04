package com.magasin.dto;

import java.util.Date;

import lombok.Data;

@Data
public class MachinePartDTO {
	private Long partsId;
	private Long machineId; // Foreign key to Machine table
	private Integer quantity;
	private Integer partsHours;
	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;

	// Include ProductDTO instead of just productId
	private ProductDTO product;
}
