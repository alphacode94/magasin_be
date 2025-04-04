package com.magasin.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.magasin.dto.ClientDTO;
import com.magasin.models.ClientType;
import com.magasin.models.Clients;
import com.magasin.repository.ClientRespository;
import com.magasin.service.ClientService;
import com.magasin.utils.MapperUtils;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service

public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRespository clientRespository;

	@Override
	public ClientDTO create(MultipartFile[] files, ClientDTO dto) {

		if (dto.getClientName() == null || dto.getClientName().isEmpty()) {
			throw new NullPointerException("Mandatory fields cannot be empty");
		}
		Optional<Clients> isDuplicateNameOpt = clientRespository.findByClientNameIgnoreCase(dto.getClientName().trim());
		Clients client = new Clients();
		ClientDTO clientDTO = new ClientDTO();
		if (isDuplicateNameOpt.isPresent() && isDuplicateNameOpt.get() != null) {
			throw new EntityExistsException("An entity with the same name already exists");
		} else {
			ModelMapper mapper = MapperUtils.getModelMapper();
			mapper.map(dto, client);
//			BeanUtils.copyProperties(clientDTO, client);
			ClientType ct = new ClientType();
			ct.setCtID(dto.getClientType().getCtID());
			ct.setCtType(dto.getClientType().getCtType());
			client.setClientType(ct);
			client.setDocumentId(UUID.randomUUID().toString());
			Clients clientNew = clientRespository.save(client);
//			BeanUtils.copyProperties(clientNew, clientDTO);
			mapper.map(clientNew, clientDTO);
			return clientDTO;
		}
	}

	@Override
	@Transactional
	public ClientDTO read(long id) {
		Optional<Clients> clientOpt = clientRespository.findById(id);
		if (clientOpt != null && !clientOpt.isEmpty()) {
			ClientDTO clientDto = new ClientDTO();
			ModelMapper mapper = MapperUtils.getModelMapper();
			mapper.map(clientOpt.get(), clientDto);
//			BeanUtils.copyProperties(clientOpt, clientDto);
			return clientDto;
		}
		throw new EntityNotFoundException("Client Not Found");
	}

	@Override
	@Transactional
	public List<ClientDTO> readAll() {
		List<ClientDTO> clientDTOList = new ArrayList<>();
		List<Clients> clientsList = clientRespository.findAll();
		if (clientsList != null && !clientsList.isEmpty()) {
			for (Clients client : clientsList) {
				ClientDTO clientDto = new ClientDTO();
				BeanUtils.copyProperties(client, clientDto);
				clientDTOList.add(clientDto);
			}
			return clientDTOList;
		}
		throw new EntityNotFoundException("Clients Not Found");
	}

	@Override
	@Transactional
	public ClientDTO update(MultipartFile[] files, ClientDTO dto) {
		Optional<Clients> clientOpt = clientRespository.findById(dto.getClientId());
		Clients client = new Clients();
		ClientDTO clientDTO = null;
		if (clientOpt.isEmpty() && clientOpt.get() == null) {
			throw new EntityNotFoundException("Record does not exist to update!");
		} else {
			if (clientOpt.get().getDocumentId() == null || clientOpt.get().getDocumentId().isEmpty())
				clientOpt.get().setDocumentId(UUID.randomUUID().toString());

			BeanUtils.copyProperties(clientDTO, client);
			clientRespository.save(client);
			BeanUtils.copyProperties(client, clientDTO);
			return clientDTO;
		}
	}

	@Override
	public void delete(long id) {
		Optional<Clients> clientOpt = clientRespository.findById(id);
		if (clientOpt.isEmpty() || clientOpt == null) {
			throw new EntityNotFoundException("Record does not exist to delete!");
		} else {
			clientRespository.deleteById(id);
		}
	}
}
