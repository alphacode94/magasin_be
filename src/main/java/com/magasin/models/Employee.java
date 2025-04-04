package com.magasin.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "Employee")
public class Employee extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EmpID")
	private Long empId;

	@Column(name = "id", unique = true, nullable = false)
	private Long id;

	@Column(name = "Matrics")
	private String matrics;

	@Column(name = "Nom")
	private String nom;

	@Column(name = "PostNom")
	private String postNom;

	@Column(name = "Equipe")
	private String equipe;

	@Column(name = "Grade")
	private String grade;

	@Column(name = "EtatCivil")
	private String etatCivil;

	@Column(name = "Telephone")
	private String telephone;

	@Column(name = "AddLine1")
	private String addLine1;

	@Column(name = "AddLine2")
	private String addLine2;

	@Column(name = "AddLine3")
	private String addLine3;

	@Column(name = "CurCode")
	private String curCode;

	@Column(name = "SalBase")
	private BigDecimal salBase;

	@Column(name = "Prime")
	private BigDecimal prime;

	@Column(name = "AlFamil")
	private BigDecimal alFamil;

	@Column(name = "TransAu")
	private BigDecimal transAu;

	@Column(name = "Child")
	private Integer child;

	@Column(name = "wDays")
	private Integer wDays;

	@Column(name = "mDays")
	private Integer mDays;

	@Column(name = "aDays")
	private Integer aDays;

	@Column(name = "LateMin")
	private Integer lateMin;

	@Column(name = "AutresImposable")
	private BigDecimal autresImposable;

	@Column(name = "QuinzaineAmount")
	private BigDecimal quinzaineAmount;

	@Column(name = "MinAdvCut")
	private BigDecimal minAdvCut;

	@Temporal(TemporalType.DATE)
	@Column(name = "JoinDate")
	private Date joinDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "PartirDate")
	private Date partirDate;

	@Column(name = "bPrime")
	private Boolean bPrime;

	@Column(name = "eStatus")
	private String eStatus;

	@Column(name = "IsGroupLeader")
	private Boolean isGroupLeader;

	@Column(name = "ReportsTo")
	private Long reportsTo; // Foreign key reference to another Employee (Supervisor)

	@Column(name = "PrimeBoss")
	private BigDecimal primeBoss;

	@Column(name = "tDays")
	private Integer tDays;

	@Column(name = "IsAbsent")
	private Boolean isAbsent;

	@Column(name = "SalaryUSD")
	private BigDecimal salaryUSD;

	@Column(name = "IsPermanent")
	private Boolean isPermanent;

	@Column(name = "IsDeclared")
	private Boolean isDeclared;

	@Column(name = "Fonction")
	private String fonction;

	@Column(name = "documentId", nullable = false, unique = true, updatable = false)
	private UUID documentId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "documentId", referencedColumnName = "documentId") // Foreign key in FileStorage
	private List<FileStorage> documents;

	@Column(name = "LastSalaryTaux")
	private BigDecimal lastSalaryTaux;

	@Column(name = "XptEmpID")
	private String xptEmpID;

	@Column(name = "OldSalBase")
	private BigDecimal oldSalBase;

	@Column(name = "OldGrade")
	private String oldGrade;

	@Lob
	@Column(name = "imgData")
	private byte[] imgData;

	@Column(name = "PIN")
	private String pin;

	public Employee() {
		this.documentId = UUID.randomUUID(); // Generate UUID when a new employee is created
	}
}
