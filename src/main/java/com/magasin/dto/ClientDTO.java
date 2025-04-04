package com.magasin.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientDTO {

	private Long clientId;

	private String documentId;

	private String clientName;

	private String abbr;

	private String sndCode;

	private String acType;

	private String noImpot;

	private String company;

	private String designation;

	private String telephone;

	private String email;

	private String address;

	private String homeAddress;

	private String postalCode;

	private String city;

	private String town;

	private String province;

	private String country;

	private ClientTypeDTO clientType;

	private String factType;

	private Double opBalance;

	private Double balPaid;

	private Double creditLimit;

	private Double discounts;

	private Double moDiscounts;

	private Double partsDiscounts;

	private String clientStatus;

	private Boolean bPrint;

	private Boolean bLocal;

	private Boolean bDoubtful;

	private Date lastVisitDate;

	private Boolean visitViewed;

	private String ssmaTimestamp;

	private Boolean bTaxExempt;

	private Boolean bNoTax;

	private Boolean bSaleCredit;

	private Long customersSegmentId;

	private String firstName;

	private String middleName;

	private String lastName;

	private String nrcNo;

	private String idNatNo;

	private String tvaNo;

	private Boolean bFiscalCell;

	private Double commissionPercentage;

	private Boolean bCreditAllowed;

	private Boolean bBCCompulsory;

	private Long salesPersonId;

	private Boolean bA4Print;

	private Long clientTypeId;

	private Boolean bCalculateNetSalePrice;

	private Boolean bJma;

	private Integer proformaValidity;

	private List<MachineDTO> machines;

	private List<FileStorageDTO> documents;
}
