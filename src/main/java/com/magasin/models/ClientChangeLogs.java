package com.magasin.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client_change_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientChangeLogs {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "logID")
	private Long logID;

	@Column(name = "LogDate", nullable = false)
	private LocalDateTime logDate;

	@Column(name = "OldbTaxExempt")
	private Boolean oldbTaxExempt;

	@Column(name = "bTaxExempt")
	private Boolean bTaxExempt;

	@Column(name = "OldbNoTax")
	private Boolean oldbNoTax;

	@Column(name = "bNoTax")
	private Boolean bNoTax;

	@Column(name = "uUser", nullable = false, length = 50)
	private String uUser;
}
