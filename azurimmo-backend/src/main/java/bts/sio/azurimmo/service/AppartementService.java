package bts.sio.azurimmo.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.dto.AppartementDTO;
import bts.sio.azurimmo.mapper.AppartementMapper;
import bts.sio.azurimmo.repository.AppartementRepository;
import lombok.Data;

@Data
@Service
public class AppartementService {
	
	 @Autowired
	 private AppartementRepository appartementRepository;

	 public Appartement saveAppartement(Appartement appartement) {
		 return appartementRepository.save(appartement);
	 }

	 public List<AppartementDTO> findByVille(String ville) {
         return appartementRepository.findByBatiment_Ville(ville)
                                     .stream()
                                     .map(AppartementMapper::toDTO)
                                     .collect(Collectors.toList());
     }
	 
	 public List<AppartementDTO> getAppartementsParBatiment(long id) {
        return appartementRepository.findByBatiment_Id(id)
        							.stream()
                                    .map(AppartementMapper::toDTO)
                                    .collect(Collectors.toList());
     }
	 
	 public List<AppartementDTO> findAppartementsBySurfaceGreaterThan(float surface) {
        return appartementRepository.findBySurfaceGreaterThan(surface)
        							.stream()
                                    .map(AppartementMapper::toDTO)
                                    .collect(Collectors.toList());
    }
	
	 public AppartementDTO saveAppartementDTO(AppartementDTO dto) {
		 Appartement entity = AppartementMapper.toEntity(dto);
		 Appartement saved = appartementRepository.save(entity);
		 return AppartementMapper.toDTO(saved);
	 }
}