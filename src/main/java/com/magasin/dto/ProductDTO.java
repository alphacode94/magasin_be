package com.magasin.dto;

import java.util.Date;

import lombok.Data;

@Data
public class ProductDTO {
	private Long productId;
	private Long productNo;
	private String vcCode;
	private String productCode;
	private String productName;
	private String modelNo;
	private String refIdent;
	private Integer quantity;
	private Double purchasePrice;
	private Double salePrice;
	private Double revisedPrice;
	private Integer minWholesaleQty;
	private Integer maxQuantity;
	private Integer minQuantity;
	private Date effectiveDate;
	private Date priceUpdatedDate;
	private Date lastUsedDate;
	private Boolean hide;
	private Integer onOrderSalesQty;
	private Integer orderQty;
	private Integer deliveredQty;
	private Integer yearlySales;
	private Double lastPurchasePrice;
	private Date lastPurchaseDate;
	private Double priceUSD;
	private Double priceZAR;
	private Double priceAlpha;
	private Integer minPurchaseOrderQty;
	private String notes;
	private Boolean isSaleBlocked;
}
