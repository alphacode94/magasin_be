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
@Table(name = "MachineParts")
public class MachineParts extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PartsID")
	private Long partsId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MachineId", referencedColumnName = "MachineId", nullable = false)
	private Machine machine;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ProductID", referencedColumnName = "ProductID", nullable = false)
	private Product product;

	@Column(name = "Quantity", nullable = false)
	private Integer quantity;

	@Column(name = "PartsHours")
	private Integer partsHours;
}
