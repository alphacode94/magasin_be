package com.magasin.enums;

import java.util.Arrays;

import lombok.Getter;
import lombok.Setter;

public enum RoleEnum {
	Photographer("photographer", 6L), Lab("lab", 7L), Seller("seller", 3L), Admin("admin", 1L);

	@Getter
	@Setter
	private Long value;
	private String label;

	/**
	 * Instantiates a new region.
	 *
	 * @param value the value
	 */
	private RoleEnum(final String label, final Long value) {
		this.value = value;
		this.label = label;
	}

	private RoleEnum() {
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
	public static RoleEnum fromValue(Long value) {
		for (RoleEnum sys : values()) {
			if (sys.value.equals(value)) {
				return sys;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}
}
