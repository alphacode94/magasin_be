package com.magasin.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Machine")
public class Machine extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MachineId")
	private Long machineId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ClientID", referencedColumnName = "ClientID", nullable = false)
	private Clients client;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ContractorID", referencedColumnName = "ClientID", nullable = false)
	private Clients contractorID;

	@Column(name = "MachineName", nullable = false, length = 100)
	private String machineName;

	@Column(name = "Hours")
	private Integer hours;

	@Column(name = "IsDiscontinued")
	private Boolean isDiscontinued;

}
