package com.magasin.enums;

import java.util.Arrays;

import lombok.Getter;
import lombok.Setter;

public enum SysConfigEnum {
	PartyImagePath("PartyImagePath", "PartyImagePath"), StoneFilePath("StoneFilePath", "StoneFilePath");

	@Getter
	@Setter
	private String value;
	private String label;

	/**
	 * Instantiates a new region.
	 *
	 * @param value the value
	 */
	private SysConfigEnum(final String label, final String value) {
		this.value = value;
		this.label = label;
	}

	private SysConfigEnum() {
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
	public static SysConfigEnum fromValue(String value) {
		for (SysConfigEnum sys : values()) {
			if (sys.value.equals(value)) {
				return sys;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}
}
