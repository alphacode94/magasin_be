package com.magasin.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.magasin.dto.MachinePartDTO;
import com.magasin.models.MachineParts;
import com.magasin.repository.MachinePartRespository;
import com.magasin.service.MachinePartService;
import com.magasin.utils.MapperUtils;

import jakarta.persistence.EntityNotFoundException;

@Service

public class MachinePartsServiceImpl implements MachinePartService {
	@Autowired
	private MachinePartRespository machinePartsRespository;

	@Override
	public MachinePartDTO create(MultipartFile[] files, MachinePartDTO dto) {

		if (dto == null && dto.getProduct() == null) {
			throw new NullPointerException("Mandatory fields cannot be empty");
		}
//		Optional<Machine> isDuplicateNameOpt = clientRespository.findByClientNameIgnoreCase(dto.getClientName().trim());
		MachineParts machine = new MachineParts();
		MachinePartDTO machineDTO = new MachinePartDTO();
		ModelMapper mapper = MapperUtils.getModelMapper();
		mapper.map(dto, machine);
//			BeanUtils.copyProperties(clientDTO, client);
		machine = machinePartsRespository.save(machine);
//			BeanUtils.copyProperties(clientNew, clientDTO);
		mapper.map(machine, machineDTO);
		return machineDTO;
	}

	@Override
	public MachinePartDTO read(long id) {
		Optional<MachineParts> resOpt = machinePartsRespository.findById(id);
		if (resOpt != null && !resOpt.isEmpty()) {
			MachinePartDTO mDTO = new MachinePartDTO();
			ModelMapper mapper = MapperUtils.getModelMapper();
			mapper.map(resOpt.get(), mDTO);
//			BeanUtils.copyProperties(clientOpt, clientDto);
			return mDTO;
		}
		throw new EntityNotFoundException("Client Not Found");
	}

	@Override
	public List<MachinePartDTO> readAllByMachineId(Long id) {
		List<MachinePartDTO> mDTOList = new ArrayList<>();
		List<MachineParts> mList = machinePartsRespository.findByMachine_MachineId(id);
		if (mList != null && !mList.isEmpty()) {
			for (MachineParts machineParts : mList) {
				MachinePartDTO machinePartDTO = new MachinePartDTO();
				BeanUtils.copyProperties(machineParts, machinePartDTO);
				mDTOList.add(machinePartDTO);
			}
			return mDTOList;
		}
		throw new EntityNotFoundException("Machine Part Not Found");
	}

	@Override
	public MachinePartDTO update(MultipartFile[] files, MachinePartDTO dto) {
		Optional<MachineParts> resOpt = machinePartsRespository.findById(dto.getPartsId());
		MachineParts machinePart = new MachineParts();
		MachinePartDTO machinePartDTO = null;
		if (resOpt.isEmpty() && resOpt.get() == null) {
			throw new EntityNotFoundException("Record does not exist to update!");
		} else {

			BeanUtils.copyProperties(machinePartDTO, machinePart);
			machinePart = machinePartsRespository.save(machinePart);
			BeanUtils.copyProperties(machinePart, machinePartDTO);
			return machinePartDTO;
		}
	}

	@Override
	public void delete(long id) {
		Optional<MachineParts> resOpt = machinePartsRespository.findById(id);
		if (resOpt.isEmpty() || resOpt == null) {
			throw new EntityNotFoundException("Record does not exist to delete!");
		} else {
			machinePartsRespository.deleteById(id);
		}
	}

	@Override
	public List<MachinePartDTO> readAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
