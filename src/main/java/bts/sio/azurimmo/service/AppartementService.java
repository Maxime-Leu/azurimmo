package bts.sio.azurimmo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.dto.AppartementDTO;
import bts.sio.azurimmo.model.dto.BatimentDTO;
import bts.sio.azurimmo.repository.AppartementRepository;
import lombok.Data;

@Data
@Service
public class AppartementService {
	
	 @Autowired
	 private AppartementRepository appartementRepository;

	 public Appartement saveAppartement(Appartement appartement) {
		 Appartement savedAppartement = appartementRepository.save(appartement);
	     return savedAppartement;
	 }
	 
	 public List<Appartement> findByVille(String ville) {
		 return appartementRepository.findByBatiment_Ville(ville);
	}
	
	 public List<Appartement> getAppartementsParBatiment(long id) {
	        return appartementRepository.findByBatiment_Id(id);
	}
	 
	public List<Appartement> getAppartementsSuperieur(float minSurface) {
		    return appartementRepository.findBySurfaceGreaterThan(minSurface);
	}
	
	public List<Appartement> getAppartements() {
        return appartementRepository.findAll();
	}

	
}