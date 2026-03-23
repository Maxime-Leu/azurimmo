package bts.sio.azurimmo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.dto.ContratDTO;
import bts.sio.azurimmo.mapper.ContratMapper;
import bts.sio.azurimmo.repository.ContratRepository;
import lombok.Data;

@Data
@Service
public class ContratService {
	
	 @Autowired
	 private ContratRepository contratRepository;

	 
	 public Contrat saveContrat(Contrat contrat) {
		 return contratRepository.save(contrat);
	 }
	 
    public Optional<ContratDTO> getContratDTO(Long id) {
        return contratRepository.findById(id)
                                 .map(ContratMapper::toDTO);
    }

    public List<ContratDTO> getContratParAppartement(long id) {
        return contratRepository.findByAppartement_Id(id)
                                .stream()
                                .map(ContratMapper::toDTO)
                                .collect(Collectors.toList());
    }
    
    public List<ContratDTO> getContratsDTO() {
		 return contratRepository.findAll()
								 .stream()
								 .map(ContratMapper::toDTO)
								 .collect(Collectors.toList());
	 }
    
	 public ContratDTO saveContratDTO(ContratDTO dto) {
		 Contrat entity = ContratMapper.toEntity(dto);
		 Contrat saved = contratRepository.save(entity);
		 return ContratMapper.toDTO(saved);
	 }
}