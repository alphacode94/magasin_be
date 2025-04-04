package com.magasin.models;

import java.math.BigDecimal;
import java.time.LocalDate;

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
@Table(name = "EmployeeConge")
public class EmployeeConge extends BaseEntity {

	@Column(name = "Num")
	private Long id;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CongeID", nullable = false)
	private Long congeId;

	@ManyToOne
	@JoinColumn(name = "empID", nullable = false)
	private Employee employee;

	@Column(name = "iMonth")
	private Integer month;

	@Column(name = "iYear")
	private Integer year;

	@Column(name = "Ref")
	private String reference;

	@Column(name = "Equipe")
	private String equipe;

	@Column(name = "Grade")
	private String grade;

	@Column(name = "SalBase", precision = 18, scale = 2)
	private BigDecimal salaryBase;

	@Column(name = "Prime", precision = 18, scale = 2)
	private BigDecimal prime;

	@Column(name = "EtatCivil")
	private String maritalStatus;

	@Column(name = "Child")
	private Integer childrenCount;

	@Column(name = "Person")
	private Integer personCount;

	@Column(name = "wDays")
	private Integer workingDays;

	@Column(name = "mDays")
	private Integer medicalDays;

	@Column(name = "aDays")
	private Integer absentDays;

	@Column(name = "LateMin")
	private Integer lateMinutes;

	@Column(name = "LateMinAmount", precision = 18, scale = 2)
	private BigDecimal lateMinAmount;

	@Column(name = "AutresImposable", precision = 18, scale = 2)
	private BigDecimal autresImposable;

	@Column(name = "AlFamil", precision = 18, scale = 2)
	private BigDecimal familyAllowance;

	@Column(name = "IndDiv", precision = 18, scale = 2)
	private BigDecimal individualAllowance;

	@Column(name = "TransportAu", precision = 18, scale = 2)
	private BigDecimal transportAllowance;

	@Column(name = "Logement", precision = 18, scale = 2)
	private BigDecimal housingAllowance;

	@Column(name = "RoundForValue", precision = 18, scale = 2)
	private BigDecimal roundForValue;

	@Column(name = "Rounding", precision = 18, scale = 2)
	private BigDecimal rounding;

	@Column(name = "INSS", precision = 18, scale = 2)
	private BigDecimal inssRate;

	@Column(name = "INSSAmount", precision = 18, scale = 2)
	private BigDecimal inssAmount;

	@Column(name = "IPR", precision = 18, scale = 2)
	private BigDecimal iprRate;

	@Column(name = "IPRAmount", precision = 18, scale = 2)
	private BigDecimal iprAmount;

	@Column(name = "AdvanceSpecial", precision = 18, scale = 2)
	private BigDecimal advanceSpecial;

	@Column(name = "Advance", precision = 18, scale = 2)
	private BigDecimal advance;

	@Column(name = "BrutTotal", precision = 18, scale = 2)
	private BigDecimal grossTotal;

	@Column(name = "RetenueTotal", precision = 18, scale = 2)
	private BigDecimal totalDeductions;

	@Column(name = "NetPaye", precision = 18, scale = 2)
	private BigDecimal netPay;

	@Column(name = "CurCode")
	private String currencyCode;

	@Column(name = "CurRate", precision = 18, scale = 6)
	private BigDecimal currencyRate;

	@Column(name = "bSocWillPayTax")
	private Boolean companyWillPayTax;

	@Column(name = "bPaid")
	private Boolean isPaid;

	@Column(name = "PaidDate")
	private LocalDate paidDate;

	// Getters and Setters
}
