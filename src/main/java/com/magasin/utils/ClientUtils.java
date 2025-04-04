package com.magasin.utils;

import org.modelmapper.ModelMapper;

import com.magasin.dto.ClientDTO;
import com.magasin.models.Clients;

public class ClientUtils {
	private static ModelMapper mapper = MapperUtils.getModelMapper();

	public static ClientDTO toClientDTO(Clients model) {

		if (model == null)
			return null;
		ClientDTO dto = mapper.map(model, ClientDTO.class);
//		dto.setCity(CityUtils.toCityDTO(model.getCity()));
		return dto;
	}

	public static Clients toAddress(ClientDTO dto) {

		if (dto == null)
			return null;
		Clients model = mapper.map(dto, Clients.class);
//		model.setCity(CityUtils.toCity(dto.getCity()));

		return model;
	}

	public static Clients toAddressExisting(ClientDTO dto, Clients existingObj) {

		if (dto == null || existingObj == null)
			return null;
		mapper.map(dto, existingObj);
//		existingObj.setCity(CityUtils.toCityExisting(dto.getCity(), existingObj.getCity()));

		return existingObj;
	}

}
