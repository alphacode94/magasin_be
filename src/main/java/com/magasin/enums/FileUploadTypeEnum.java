package com.magasin.enums;

import java.util.Arrays;

import lombok.Getter;
import lombok.Setter;

public enum FileUploadTypeEnum {
	BON_DE_LIVRAISON("Bon de livraison", "Blc"), PROFORMA("Proforma", "Proforma"),
	PURCHASE_ORDER_BY_CLIENT("Purchase Order By ClientID", "PurOrder"),
	PURCHASE_ORDER_BY_SUPPLIER("Purchase Order By SupplierID", "PurOrder"),
	PURCHASE_BY_CLIENT("Purchase By ClientID", "Purchase"), PURCHASE_BY_SUPPLIER("Purchase By SupplierID", "Purchase"),
	CASH_BY_CLIENT("Cash By ClientID", "Cash"), CASH_BY_SUPPLIER("Cash By SupplierID", "Cash"),
	CASH_BY_EMPLOYEE("Cash By Employee", "Cash"), SALES_RETURNED("Sales Returned", "salesreturned"),
	PURCHASE_RETURNED("Purchase Returned", "purchasereturned"), CASH_TRANSACTIONS("Cash transactions", "Cash"),
	CLIENT_PERSONAL_DOCUMENTS("Client personal documents", "Client"),
	SUPPLIER_PERSONAL_DOCUMENTS("Supplier personal documents", "Supplier"),
	EMPLOYEE_PERSONAL_DOCUMENTS("Employee personal documents", "Employee"), VENTE_CASH("Vente Cash", "Vte"),
	VENTE_CASH_1("Vente Cash 1", "VteB"),
	PURCHASE_ORDER_LOCAL_BY_SUPPLIER("Purchase Order Local By SupplierID", "PurOrderLocal"),
	TVA_RECUPERER("TVA RECUPERER", "TvaRecuperer"), VENTE_CREDIT("Vente Credit", "Blc"),
	IMPORTATION("Importation", "Importation"), SUPPLIER_INVOICES("Supplier Invoices", "SupplierInvoices"),
	Images("Images", "img");

	;

	@Getter
	@Setter
	private String value;
	private String label;

	/**
	 * Instantiates a new region.
	 *
	 * @param value the value
	 */
	private FileUploadTypeEnum(final String label, final String value) {
		this.value = value;
		this.label = label;
	}

	private FileUploadTypeEnum() {
	}

	public String getLabel() {
		return label;
	}

	/**
	 * From value.
	 *
	 * @param value the value
	 * @return the region
	 */
	public static FileUploadTypeEnum fromValue(String value) {
		for (FileUploadTypeEnum sys : values()) {
			if (sys.value.equals(value)) {
				return sys;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}
}
