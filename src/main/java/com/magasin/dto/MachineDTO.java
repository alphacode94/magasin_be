package com.magasin.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MachineDTO {
	private Long machineId;
	private ClientDTO clientId; // Foreign key from Client table
	private ClientDTO contractorId; // Foreign key from Client table
	private String machineName;
	private Integer hours;
	private Boolean isDiscontinued;
	private Date createdDate;
	private String createdBy;
	private Date modifiedDate;
	private String modifiedBy;

	// List of machine parts with product details
	private List<MachinePartDTO> machineParts;
}