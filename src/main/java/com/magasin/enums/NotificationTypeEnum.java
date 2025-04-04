package com.magasin.enums;

import java.util.Arrays;

import lombok.Getter;
import lombok.Setter;

public enum NotificationTypeEnum {
	SELLER_BID_REJECTED("Bid Rejected", "BID_REJECTED", "You have rejected a bid."),
	SELLER_BID_ACCEPTED("Bid Accepted", "BID_ACCEPTED", "You have accepted a bid."),
	SELLER_OFFER_ACCEPTED("Offer Accepted", "OFFER_ACCEPTED", "You have accepted an offer."),
	SELLER_OFFER_REJECTED("Offer Rejected", "OFFER_REJECTED", "You have rejected an offer."),
	SELLER_BID_PLACED("Bid Placed", "BID_PLACED", "A new bid has been placed on your item."),
	SELLER_OFFER_PLACED("Offer Placed", "OFFER_PLACED", "A new offer has been placed on your item."),
	STONE_SOLD("Stone Sold", "STONE_SOLD", "Your stone has been sold."),
	AD_POSTED("Ad Posted", "AD_POSTED", "Your ad has been posted."),
	AD_APPROVED("Ad APPROVED", "AD_APPROVED", "Your ad has been Approved."),
	ITEM_LIVE("Item Live", "ITEM_LIVE", "Your item is now live on the site."),
	BID_REJECTED("Bid Rejected", "BID_REJECTED", "Your bid has been rejected."),
	BID_ACCEPTED("Bid Accepted", "BID_ACCEPTED", "Your bid has been accepted."),
	OFFER_ACCEPTED("Offer Accepted", "OFFER_ACCEPTED", "Your offer has been accepted."),
	OFFER_REJECTED("Offer Rejected", "OFFER_REJECTED", "Your offer has been rejected."),
	BID_PLACED("Bid Placed", "BID_PLACED", "A new bid has been placed on your item."),
	OFFER_PLACED("Offer Placed", "OFFER_PLACED", "A new offer has been placed on your item."),

	NEW_MESSAGE("New Message", "NEW_MESSAGE", "You have received a new message."),
	ACCOUNT_VERIFIED("Account Verified", "ACCOUNT_VERIFIED", "Your account has been verified."),
	PAYMENT_VERIFIED("Payment Verified", "PAYMENT_VERIFIED", "Your payment has been verified.");

	@Getter
	@Setter
	private String value;
	private String label;
	private String message;

	/**
	 * Instantiates a new region.
	 *
	 * @param value the value
	 */
//	private NotificationTypeEnum(final String label,final String value) {
//		this.value = value;
//		this.label = label;
//	}
	private NotificationTypeEnum(final String label, final String value, final String message) {
		this.label = label;
		this.value = value;
		this.message = message;
	}

	private NotificationTypeEnum() {
	}

	public String getLabel() {
		return label;
	}

	public String getMessage() {
		return message;
	}

	/**
	 * From value.
	 *
	 * @param value the value
	 * @return the region
	 */
	public static NotificationTypeEnum fromValue(String value) {
		for (NotificationTypeEnum sys : values()) {
			if (sys.value.equals(value)) {
				return sys;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}
}
