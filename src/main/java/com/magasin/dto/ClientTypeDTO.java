package com.magasin.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClientTypeDTO {

	private Long ctID;

	private String ctType;

	private String ctDesc;
}
