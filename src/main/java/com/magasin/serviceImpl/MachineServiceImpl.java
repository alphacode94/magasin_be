package com.magasin.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.magasin.dto.MachineDTO;
import com.magasin.models.Machine;
import com.magasin.repository.MachineRespository;
import com.magasin.service.MachineService;
import com.magasin.utils.MapperUtils;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service

public class MachineServiceImpl implements MachineService {
	@Autowired
	private MachineRespository machineRespository;

	@Override
	@Transactional
	public MachineDTO create(MultipartFile[] files, MachineDTO dto) {

		if (dto == null && dto.getMachineName().isEmpty()) {
			throw new NullPointerException("Mandatory fields cannot be empty");
		}
//		Optional<Machine> isDuplicateNameOpt = clientRespository.findByClientNameIgnoreCase(dto.getClientName().trim());
		Machine machine = new Machine();
		MachineDTO machineDTO = new MachineDTO();
		ModelMapper mapper = MapperUtils.getModelMapper();
		mapper.map(dto, machine);
		machine.getClient().setClientId(dto.getClientId().getClientId());
		machine.getContractorID().setClientId(dto.getContractorId().getClientId());
//			BeanUtils.copyProperties(clientDTO, client);
		machine = machineRespository.save(machine);
//			BeanUtils.copyProperties(clientNew, clientDTO);
		mapper.map(machine, machineDTO);
		return machineDTO;
	}

	@Override
	@Transactional
	public MachineDTO read(long id) {
		Optional<Machine> resOpt = machineRespository.findById(id);
		if (resOpt != null && !resOpt.isEmpty()) {
			MachineDTO mDTO = new MachineDTO();
			ModelMapper mapper = MapperUtils.getModelMapper();
			mapper.map(resOpt.get(), mDTO);
//			BeanUtils.copyProperties(clientOpt, clientDto);
			return mDTO;
		}
		throw new EntityNotFoundException("Client Not Found");
	}

	@Override
	@Transactional
	public List<MachineDTO> readAll() {
		List<MachineDTO> mDTOList = new ArrayList<>();
		List<Machine> mList = machineRespository.findAll();
		if (mList != null && !mList.isEmpty()) {
			for (Machine machine : mList) {
				MachineDTO machineDto = new MachineDTO();
//				BeanUtils.copyProperties(machine, machineDto);
				ModelMapper mapper = MapperUtils.getModelMapper();
				mapper.map(machine, machineDto);
				mDTOList.add(machineDto);
			}
			return mDTOList;
		}
		throw new EntityNotFoundException("Machine Not Found");
	}

	@Override
	@Transactional
	public MachineDTO update(MultipartFile[] files, MachineDTO dto) {
		Optional<Machine> resOpt = machineRespository.findById(dto.getMachineId());
		Machine machine = new Machine();
		MachineDTO machineDTO = null;
		if (resOpt.isEmpty() && resOpt.get() == null) {
			throw new EntityNotFoundException("Record does not exist to update!");
		} else {

			BeanUtils.copyProperties(machineDTO, machine);
			machine = machineRespository.save(machine);
			BeanUtils.copyProperties(machine, machineDTO);
			return machineDTO;
		}
	}

	@Override
	@Transactional
	public void delete(long id) {
		Optional<Machine> resOpt = machineRespository.findById(id);
		if (resOpt.isEmpty() || resOpt == null) {
			throw new EntityNotFoundException("Record does not exist to delete!");
		} else {
			machineRespository.deleteById(id);
		}
	}
}
