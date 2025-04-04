package com.magasin.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.magasin.dto.SupplierDTO;
import com.magasin.models.Supplier;
import com.magasin.repository.SupplierRespository;
import com.magasin.service.SupplierService;
import com.magasin.utils.MapperUtils;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service

public class SupplierServiceImpl implements SupplierService {
	@Autowired
	private SupplierRespository supplierRespository;

	@Override
	public SupplierDTO create(MultipartFile[] files, SupplierDTO dto) {

		if (dto.getSupplierName() == null || dto.getSupplierName().isEmpty()) {
			throw new NullPointerException("Mandatory fields cannot be empty");
		}
		Optional<Supplier> isDuplicateNameOpt = supplierRespository
				.findBySupplierNameIgnoreCase(dto.getSupplierName().trim());
		Supplier supplier = new Supplier();
		SupplierDTO supplierDTO = new SupplierDTO();
		if (isDuplicateNameOpt.isPresent() && isDuplicateNameOpt.get() != null) {
			throw new EntityExistsException("An entity with the same name already exists");
		} else {
			ModelMapper mapper = MapperUtils.getModelMapper();
			mapper.map(dto, supplier);
//			BeanUtils.copyProperties(clientDTO, client);
			Supplier supplierNew = supplierRespository.save(supplier);
//			BeanUtils.copyProperties(clientNew, clientDTO);
			mapper.map(supplierNew, supplierDTO);
			return supplierDTO;
		}
	}

	@Override
	public SupplierDTO read(long id) {
		Optional<Supplier> supplierOpt = supplierRespository.findById(id);
		if (supplierOpt != null && !supplierOpt.isEmpty()) {
			SupplierDTO supplierDto = new SupplierDTO();
			ModelMapper mapper = MapperUtils.getModelMapper();
			mapper.map(supplierOpt.get(), supplierDto);
//			BeanUtils.copyProperties(clientOpt, clientDto);
			return supplierDto;
		}
		throw new EntityNotFoundException("Client Not Found");
	}

	@Override
	public List<SupplierDTO> readAll() {
		List<SupplierDTO> supDTOList = new ArrayList<>();
		List<Supplier> supList = supplierRespository.findAll();
		if (supList != null && !supList.isEmpty()) {
			for (Supplier sup : supList) {
				SupplierDTO supplierDTO = new SupplierDTO();
				BeanUtils.copyProperties(sup, supplierDTO);
				supDTOList.add(supplierDTO);
			}
			return supDTOList;
		}
		throw new EntityNotFoundException("Clients Not Found");
	}

	@Override
	public SupplierDTO update(MultipartFile[] files, SupplierDTO dto) {
		Optional<Supplier> supplierOpt = supplierRespository.findById(dto.getSupplierId());
		Supplier supplier = new Supplier();
		SupplierDTO supplierDTO = new SupplierDTO();
		if (supplierOpt.isEmpty() && supplierOpt.get() == null) {
			throw new EntityNotFoundException("Record does not exist to update!");
		} else {
			BeanUtils.copyProperties(supplierDTO, supplier);
			supplierRespository.save(supplier);
			BeanUtils.copyProperties(supplier, supplierDTO);
			return supplierDTO;
		}
	}

	@Override
	public void delete(long id) {
		Optional<Supplier> supplierOpt = supplierRespository.findById(id);
		if (supplierOpt.isEmpty() || supplierOpt == null) {
			throw new EntityNotFoundException("Record does not exist to delete!");
		} else {
			supplierRespository.deleteById(id);
		}
	}
}
