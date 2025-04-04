package com.magasin.models;

import java.util.Date;

import com.magasin.utils.TokenUtils;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PROTECTED)
@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

	/** The created at. */
	@Column(name = "create_date", updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	Date createdAt;

	/** The created by. */
	@Column(name = "created_by", length = 100, updatable = false)
	String createdBy;

	/** The updated at. */
	@Column(name = "updated_date")
	@Temporal(TemporalType.TIMESTAMP)
	Date updatedAt;

	/** The updated by. */
	@Column(name = "updated_by", length = 100)
	String updatedBy;

	@Column(columnDefinition = "tinyint(1) default 1")
	private boolean active;

	@Column(columnDefinition = "tinyint(1) default 0")
	private boolean isDeleted;

	/**
	 * Sets createdAt before insert.
	 */
	@PrePersist
	public void setCreationData() {
		try {
			this.createdAt = new Date();
			this.createdBy = TokenUtils.getFieldFromToken("username");
			this.active = true;
			this.isDeleted = false;

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

	/**
	 * Sets updatedAt before update.
	 */
	@PreUpdate
	public void setChangeData() {
		try {
			this.updatedAt = new Date();
			this.updatedBy = TokenUtils.getFieldFromToken("username");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
		}
	}

}
