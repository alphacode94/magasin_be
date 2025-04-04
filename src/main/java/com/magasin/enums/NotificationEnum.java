package com.magasin.enums;

import java.util.Arrays;

import lombok.Getter;
import lombok.Setter;

public enum NotificationEnum {
	uploadImagePending("uploadImagePending", "Upload ad Image Pending"),
	uploadImageComplete("uploadImageComplete", "Upload ad Image Completed");

	@Getter
	@Setter
	private String value;
	private String label;

	/**
	 * Instantiates a new region.
	 *
	 * @param value the value
	 */
	private NotificationEnum(final String label, final String value) {
		this.value = value;
		this.label = label;
	}

	private NotificationEnum() {
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
	public static NotificationEnum fromValue(String value) {
		for (NotificationEnum sys : values()) {
			if (sys.value.equals(value)) {
				return sys;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}
}
