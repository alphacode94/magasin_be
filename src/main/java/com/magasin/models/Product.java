package com.magasin.models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Entity
@Table(name = "Product")
public class Product extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ProductID")
	private Long productId;

	@Column(name = "ProductNo", unique = true)
	private Long productNo;

	@Column(name = "vcCode")
	private String vcCode;

	@Column(name = "ProductCode", unique = true, nullable = false)
	private String productCode;

	@Column(name = "ProductName", nullable = false)
	private String productName;

	@Column(name = "ModelNo")
	private String modelNo;

	@Column(name = "RefIdent")
	private String refIdent;

	@Column(name = "Qty")
	private Integer quantity;

	@Column(name = "PrxAcha")
	private Double purchasePrice;

	@Column(name = "FobCoef")
	private Double fobCoefficient;

	@Column(name = "PoidPce")
	private Double weightPerPiece;

	@Column(name = "MarBene")
	private Double marginBenefit;

	@Column(name = "PrxRevi")
	private Double revisedPrice;

	@Column(name = "SalePrice")
	private Double salePrice;

	@Column(name = "MinWSQty")
	private Integer minWholesaleQty;

	@Column(name = "NewPrxAcha")
	private Double newPurchasePrice;

	@Column(name = "NewFobCoef")
	private Double newFobCoefficient;

	@Column(name = "NewPoidPce")
	private Double newWeightPerPiece;

	@Column(name = "NewMarBene")
	private Double newMarginBenefit;

	@Column(name = "NewPrxRevi")
	private Double newRevisedPrice;

	@Column(name = "NewSalePrice")
	private Double newSalePrice;

	@Column(name = "EffDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date effectiveDate;

	@Column(name = "CodeRayo")
	private String codeRayo;

	@Column(name = "CodeTag")
	private String codeTag;

	@Column(name = "CodeTiro")
	private String codeTiro;

	@Column(name = "MaxQty")
	private Integer maxQuantity;

	@Column(name = "MinQty")
	private Integer minQuantity;

	@Column(name = "CodeArt")
	private String codeArt;

	@Column(name = "PriceUpdatedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date priceUpdatedDate;

	@Column(name = "LastUsedDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastUsedDate;

	@Column(name = "uUser")
	private String updatedBy;

	@Column(name = "Hide")
	private Boolean hide;

	@Column(name = "OnOrderSalesQty")
	private Integer onOrderSalesQty;

	@Column(name = "OnOrderQty")
	private Integer onOrderQty;

	@Column(name = "OrderQty")
	private Integer orderQty;

	@Column(name = "DeliveredQty")
	private Integer deliveredQty;

	@Column(name = "YlySales")
	private Integer yearlySales;

	@Column(name = "Last_Pur_Price")
	private Double lastPurchasePrice;

	@Column(name = "Last_Pur_Date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastPurchaseDate;

	@Column(name = "PrixUSD")
	private Double priceUSD;

	@Column(name = "PrixAlpha")
	private Double priceAlpha;

	@Column(name = "NewAlpha")
	private Double newAlpha;

	@Column(name = "NewPoid")
	private Double newPoid;

	@Column(name = "DhlMaxQty")
	private Integer dhlMaxQty;

	@Column(name = "BoxQty")
	private Integer boxQty;

	@Column(name = "PalQty")
	private Integer palletQty;

	@Column(name = "PrixBosch")
	private Double priceBosch;

	@Column(name = "RemiseBosch")
	private Double remiseBosch;

	@Column(name = "GrID")
	private String groupId;

	@Column(name = "pChange")
	private Boolean priceChange;

	@Column(name = "xFc")
	private Double exchangeFactor;

	@Column(name = "AvgFobPrice")
	private Double avgFobPrice;

	@Column(name = "AvgCifPrice")
	private Double avgCifPrice;

	@Column(name = "txtNotes", length = 500)
	private String notes;

	@Column(name = "bNoRemise")
	private Boolean noRemise;

	@Column(name = "dblLength")
	private Double length;

	@Column(name = "dblBreadth")
	private Double breadth;

	@Column(name = "dblHeight")
	private Double height;

	@Column(name = "WSPercentage")
	private Double wholesalePercentage;

	@Column(name = "AirPrice")
	private Double airPrice;

	@Column(name = "SeaPrice")
	private Double seaPrice;

	@Column(name = "MinPurOrdQty")
	private Integer minPurchaseOrderQty;

	@Column(name = "ProductsSegmentId")
	private Long productsSegmentId;

	@Column(name = "LaboReserveQty")
	private Integer laboReserveQty;

	@Column(name = "IsSaleBlocked")
	private Boolean isSaleBlocked;

	@Column(name = "bSyncKIN")
	private Boolean syncKIN;

	@Column(name = "bSyncLUB")
	private Boolean syncLUB;

	@Column(name = "bSyncKLZ")
	private Boolean syncKLZ;

	@Column(name = "bPortalSync")
	private Boolean portalSync;

	@Column(name = "PortalSyncDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date portalSyncDate;

	@Column(name = "PrixZAR")
	private Double priceZAR;

	@Column(name = "QtyKin")
	private Integer quantityKin;

	@Column(name = "QtyLub")
	private Integer quantityLub;

	@Column(name = "QtyKwz")
	private Integer quantityKwz;

	@Column(name = "CodeRayo2")
	private String codeRayo2;

	@Column(name = "CodeTag2")
	private String codeTag2;

	@Column(name = "CodeTiro2")
	private String codeTiro2;

	@Column(name = "PrixAED")
	private Double priceAED;
}
