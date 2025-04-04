package com.magasin.enums;

import java.util.Arrays;

import lombok.Getter;
import lombok.Setter;

public enum FileTypeEnum {
	party("party", 1), stone("stone", 2);

	@Getter
	@Setter
	private int value;
	private String label;

	/**
	 * Instantiates a new region.
	 *
	 * @param value the value
	 */
	private FileTypeEnum(final String label, final int value) {
		this.value = value;
		this.label = label;
	}

	private FileTypeEnum() {
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
	public static FileTypeEnum fromValue(int value) {
		for (FileTypeEnum sys : values()) {
			if (sys.equals(value)) {
				return sys;
			}
		}
		throw new IllegalArgumentException(
				"Unknown enum type " + value + ", Allowed values are " + Arrays.toString(values()));
	}
}
