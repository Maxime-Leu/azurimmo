package bts.sio.azurimmo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.dto.AppartementDTO;
import bts.sio.azurimmo.model.dto.BatimentDTO;
import bts.sio.azurimmo.model.mapper.AppartementMapper;
import bts.sio.azurimmo.repository.AppartementRepository;
import lombok.Data;

@Data
@Service
public class AppartementService {
	
	 @Autowired
	 private AppartementRepository appartementRepository;

	 public AppartementDTO saveAppartement(AppartementDTO dto) {
		 Appartement entity = AppartementMapper.toEntity(dto);
	     Appartement saved = appartementRepository.save(entity);
	     return AppartementMapper.toDTO(saved);
	 }
	 
	 public List<AppartementDTO> findByVille(String ville) {
		 List<Appartement> list = appartementRepository.findByBatiment_Ville(ville);
		 return list.stream()
				 .map(AppartementMapper::toDTO)
				 .collect(Collectors.toList());
	}
	
	 public List<AppartementDTO> getAppartementsParBatiment(long id) {
	        return appartementRepository.findByBatiment_Id(id)
	        		.stream()
	        		.map(AppartementMapper::toDTO)
					.collect(Collectors.toList());
	}
	 
	public List<AppartementDTO> getAppartementsSuperieur(float minSurface) {
		    return appartementRepository.findBySurfaceGreaterThan(minSurface)
		    		.stream()
	        		.map(AppartementMapper::toDTO)
					.collect(Collectors.toList());
	}
	
	public List<AppartementDTO> getAppartements() {
		List<Appartement> list = appartementRepository.findAll();
		return list.stream()
				.map(AppartementMapper::toDTO)
				 .collect(Collectors.toList());
				
	}

	
}