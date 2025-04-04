package com.magasin.models;

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
@Table(name = "client_type")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientType {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ctID")
	private Long ctID;

	@Column(name = "ctType", nullable = false, length = 50, unique = true)
	private String ctType;

	@Column(name = "ctDesc", length = 255)
	private String ctDesc;
}
