package com.magasin.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "EmployeeAdvance")
public class EmployeeAdvance extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "empID", nullable = false)
	private Employee employee;

	@Column(name = "AccID", nullable = false)
	private Long accountId;

	@Column(name = "tDate", nullable = false)
	private LocalDate transactionDate;

	@Column(name = "tTime", nullable = false)
	private LocalTime transactionTime;

	@Column(name = "iMonth", nullable = false)
	private Integer month;

	@Column(name = "iYear", nullable = false)
	private Integer year;

	@Column(name = "Reference")
	private String reference;

	@Column(name = "tType")
	private String transactionType;

	@Column(name = "tSubType")
	private String transactionSubType;

	@Column(name = "tDesc")
	private String description;

	@Column(name = "CurCode")
	private String currencyCode;

	@Column(name = "CurRate", precision = 10, scale = 4)
	private BigDecimal currencyRate;

	@Column(name = "Amt", precision = 18, scale = 2)
	private BigDecimal amount;

	@Column(name = "AmtUnUsed", precision = 18, scale = 2)
	private BigDecimal amountUnused;

	@Column(name = "AmtUSD", precision = 18, scale = 2)
	private BigDecimal amountUSD;
}
