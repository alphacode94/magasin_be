package com.magasin.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Data
@Setter
public class EmployeeDTO {
	private Long empId;
	private Long id;
	private String matrics;
	private String nom;
	private String postNom;
	private String equipe;
	private String grade;
	private String etatCivil;
	private String telephone;
	private String addLine1;
	private String addLine2;
	private String addLine3;
	private String curCode;
	private BigDecimal salBase;
	private BigDecimal prime;
	private BigDecimal alFamil;
	private BigDecimal transAu;
	private Integer child;
	private Integer wDays;
	private Integer mDays;
	private Integer aDays;
	private Integer lateMin;
	private BigDecimal autresImposable;
	private BigDecimal quinzaineAmount;
	private BigDecimal minAdvCut;
	private Date joinDate;
	private Date partirDate;
	private Boolean bPrime;
	private String eStatus;
	private Boolean isGroupLeader;
	private Long reportsTo;
	private BigDecimal primeBoss;
	private Integer tDays;
	private Boolean isAbsent;
	private BigDecimal salaryUSD;
	private Boolean isPermanent;
	private Boolean isDeclared;
	private String fonction;
	private UUID documentId;
	private List<FileStorageDTO> documents;
	private BigDecimal lastSalaryTaux;
	private String xptEmpID;
	private BigDecimal oldSalBase;
	private String oldGrade;
	private byte[] imgData;
	private String pin;
}
