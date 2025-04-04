package com.magasin.serviceImpl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.magasin.dto.EmployeeDTO;
import com.magasin.enums.FileUploadTypeEnum;
import com.magasin.exception.InvalidFileException;
import com.magasin.models.Employee;
import com.magasin.models.FileStorage;
import com.magasin.repository.EmployeeRespository;
import com.magasin.repository.FileStorageRespository;
import com.magasin.service.EmployeeService;
import com.magasin.utils.CommonUtils;
import com.magasin.utils.MapperUtils;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service

public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRespository empRespository;

	@Autowired
	private FileStorageRespository fsRespository;

	@Override
	public EmployeeDTO create(MultipartFile[] files, EmployeeDTO dto) {

		if (dto.getNom() == null || dto.getNom().isEmpty() || dto.getSalBase().equals(0)) {
			throw new NullPointerException("Mandatory fields cannot be empty");
		}
		Optional<Employee> isDuplicateNameOpt = empRespository.findByNomIgnoreCase(dto.getNom().trim());
		Employee emp = new Employee();
		EmployeeDTO empDTO = new EmployeeDTO();
		if (isDuplicateNameOpt.isPresent() && isDuplicateNameOpt.get() != null) {
			throw new EntityExistsException("An entity with the same name already exists");
		} else {
			ModelMapper mapper = MapperUtils.getModelMapper();
			mapper.map(dto, emp);
//			BeanUtils.copyProperties(clientDTO, client);
			Employee empNew = empRespository.save(emp);
//			BeanUtils.copyProperties(clientNew, clientDTO);
			try {
				List<FileStorage> empFiles = fillExistingFiles(emp.getDocumentId());
				if (files != null)
					for (MultipartFile file : files) {

						String fileName = CommonUtils.generateMilliSeconds() + "_" + file.getOriginalFilename();
						String filePath = CommonUtils.uploadFile(FileUploadTypeEnum.Images.getValue(), fileName,
								file.getBytes());
						String fileExtension = FilenameUtils.getExtension(file.getOriginalFilename()).toLowerCase();
						String folder = null;
						if (fileExtension.equalsIgnoreCase("jpg") || fileExtension.equalsIgnoreCase("jpeg")
								|| fileExtension.equalsIgnoreCase("png")) {
							folder = FileUploadTypeEnum.Images.getValue();
						} else {
							folder = FileUploadTypeEnum.EMPLOYEE_PERSONAL_DOCUMENTS.getValue();
						}
						if (filePath == null) {
							throw new InvalidFileException("unable to upload file");
						}

						FileStorage empFile = new FileStorage();
						empFile.setFileUrl(filePath);
						empFile.setOriginalName(file.getOriginalFilename());
						empFile.setContentType(file.getContentType());
						empFile.setDocumentId(emp.getDocumentId().toString());
						empFiles.add(empFile);

					} /// end of for files
				emp.setDocuments(empFiles);
				empNew = empRespository.save(emp);
			} catch (Exception e) {
				e.printStackTrace();
			}

			mapper.map(empNew, empDTO);
			return empDTO;
		}
	}

	private List<FileStorage> fillExistingFiles(UUID documentId) {
		Set<FileStorage> existingFiles = new HashSet<>();

		if (documentId == null) {
			return new ArrayList<>();
		}
		List<FileStorage> files = fsRespository.findByDocumentId(documentId.toString());
		for (FileStorage file : files) {
			existingFiles.add(file);
		}
		List<FileStorage> mainList = new ArrayList<FileStorage>();
		mainList.addAll(existingFiles);
		return mainList;

	}

	@Override
	public EmployeeDTO read(long id) {
		Optional<Employee> empOpt = empRespository.findById(id);
		if (empOpt != null && !empOpt.isEmpty()) {
			EmployeeDTO empDto = new EmployeeDTO();
			ModelMapper mapper = MapperUtils.getModelMapper();
			mapper.map(empOpt.get(), empDto);
//			BeanUtils.copyProperties(clientOpt, clientDto);
			return empDto;
		}
		throw new EntityNotFoundException("Client Not Found");
	}

	@Override
	public List<EmployeeDTO> readAll() {
		List<EmployeeDTO> empDTOList = new ArrayList<>();
		List<Employee> empList = empRespository.findAll();
		if (empList != null && !empList.isEmpty()) {
			for (Employee emp : empList) {
				EmployeeDTO empDto = new EmployeeDTO();
				BeanUtils.copyProperties(emp, empDto);
				empDTOList.add(empDto);
			}
			return empDTOList;
		}
		throw new EntityNotFoundException("Clients Not Found");
	}

	@Override
	public EmployeeDTO update(MultipartFile[] files, EmployeeDTO dto) {
		return dto;
//		Optional<Clients> clientOpt = clientRespository.findById(dto.getClientId());
//		Clients client = new Clients();
//		ClientDTO clientDTO = null;
//		if (clientOpt.isEmpty() && clientOpt.get() == null) {
//			throw new EntityNotFoundException("Record does not exist to update!");
//		} else {
//
//			BeanUtils.copyProperties(clientDTO, client);
//			clientRespository.save(client);
//			BeanUtils.copyProperties(client, clientDTO);
//			return clientDTO;
//		}
	}

	@Override
	public void delete(long id) {
//		Optional<Clients> clientOpt = clientRespository.findById(id);
//		if (clientOpt.isEmpty() || clientOpt == null) {
//			throw new EntityNotFoundException("Record does not exist to delete!");
//		} else {
//			clientRespository.deleteById(id);
//		}
	}
}
