package bts.sio.azurimmo.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bts.sio.azurimmo.model.Paiement;
import bts.sio.azurimmo.dto.PaiementDTO;
import bts.sio.azurimmo.mapper.PaiementMapper;
import bts.sio.azurimmo.repository.PaiementRepository;
import lombok.Data;

@Data
@Service
public class PaiementService {

	 @Autowired
	 private PaiementRepository paiementRepository;

	 public Paiement savePaiement(Paiement paiement) {
		 return paiementRepository.save(paiement);
	 }
	 
	    
	 public Optional<PaiementDTO> getPaiementDTO(Long id) {
	        return paiementRepository.findById(id)
	                                 .map(PaiementMapper::toDTO);
	 }
	 
	    
	 public List<PaiementDTO> getPaiementParContrat(long id) {
	        return paiementRepository.findByContrat_Id(id)
	                                .stream()
	                                .map(PaiementMapper::toDTO)
	                                .collect(Collectors.toList());
	    }
	
	   
	 public List<PaiementDTO> getPaiementsDTO() {
			 return paiementRepository.findAll()
									 .stream()
									 .map(PaiementMapper::toDTO)
									 .collect(Collectors.toList());
	}
	 
	 
	 public PaiementDTO savePaiementDTO(PaiementDTO dto) {
		 Paiement entity = PaiementMapper.toEntity(dto);
		 Paiement saved = paiementRepository.save(entity);
		 return PaiementMapper.toDTO(saved);
	 }
}
