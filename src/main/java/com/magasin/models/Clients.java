package com.magasin.models;

import java.sql.Date;
import java.util.List;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "clients")
@Table(name = "clients")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@SQLDelete(sql = "Update clients SET is_deleted=true where id = ?")
@Where(clause = "is_deleted = false")
public class Clients extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ClientID")
	private Long clientId;

	@Column(name = "ClientName")
	private String clientName;

	@Column(name = "Abbr")
	private String abbr;

	@Column(name = "SndCode")
	private String sndCode;

	@Column(name = "AcType")
	private String acType;

	@Column(name = "NoImpot")
	private String noImpot;

	@Column(name = "Company")
	private String company;

	@Column(name = "Designation")
	private String designation;

	@Column(name = "Telephone")
	private String telephone;

	@Column(name = "Email")
	private String email;

	@Column(name = "Address")
	private String address;

	@Column(name = "HomeAddress")
	private String homeAddress;

	@Column(name = "PostalCode")
	private String postalCode;

	@Column(name = "City")
	private String city;

	@Column(name = "Town")
	private String town;

	@Column(name = "Province")
	private String province;

	@Column(name = "Country")
	private String country;

	@ManyToOne
	@JoinColumn(name = "ClientType", referencedColumnName = "ctID", nullable = false)
	private ClientType clientType;

	@Column(name = "FactType")
	private String factType;

	@Column(name = "OpBalance")
	private Double opBalance;

	@Column(name = "BalPaid")
	private Double balPaid;

	@Column(name = "CreditLimit")
	private Double creditLimit;

	@Column(name = "Discounts")
	private Double discounts;

	@Column(name = "MODiscounts")
	private Double moDiscounts;

	@Column(name = "PartsDiscounts")
	private Double partsDiscounts;

	@Column(name = "ClientStatus")
	private String clientStatus;

	@Column(name = "bPrint")
	private Boolean bPrint;

	@Column(name = "bLocal")
	private Boolean bLocal;

	@Column(name = "bDoubtful")
	private Boolean bDoubtful;

	@Column(name = "LastVisitDate")
	private Date lastVisitDate;

	@Column(name = "VisitViewed")
	private Boolean visitViewed;

	@Column(name = "bTaxExempt")
	private Boolean bTaxExempt;

	@Column(name = "bNoTax")
	private Boolean bNoTax;

	@Column(name = "bSaleCredit")
	private Boolean bSaleCredit;

	@Column(name = "CustomersSegmentId")
	private Long customersSegmentId;

	@Column(name = "FirstName")
	private String firstName;

	@Column(name = "MiddleName")
	private String middleName;

	@Column(name = "LastName")
	private String lastName;

	@Column(name = "NRCNo")
	private String nrcNo;

	@Column(name = "IdNatNo")
	private String idNatNo;

	@Column(name = "TVANo")
	private String tvaNo;

	@Column(name = "bFiscalCell")
	private Boolean bFiscalCell;

	@Column(name = "CommissionPercentage")
	private Double commissionPercentage;

	@Column(name = "bCreditAllowed")
	private Boolean bCreditAllowed;

	@Column(name = "bBCCompulsory")
	private Boolean bBCCompulsory;

	@Column(name = "SalesPersonID")
	private Long salesPersonId;

	@Column(name = "bA4Print")
	private Boolean bA4Print;

	@Column(name = "ClientTypeID")
	private Long clientTypeId;

	@Column(name = "bCalculateNetSalePrice")
	private Boolean bCalculateNetSalePrice;

	@Column(name = "bJMA")
	private Boolean bJma;

	@Column(name = "ProformaValidity")
	private Integer proformaValidity;

	@Column(name = "documentId", columnDefinition = "VARCHAR(36)", nullable = false, unique = true, updatable = false)
	private String documentId;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "documentId", referencedColumnName = "documentId") // Foreign key in FileStorage
	private List<FileStorage> documents;

}
