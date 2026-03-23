package bts.sio.azurimmo.mapper;

import bts.sio.azurimmo.model.Paiement;
import bts.sio.azurimmo.dto.PaiementDTO;

public class PaiementMapper {

	
	public static PaiementDTO toDTO(Paiement p) {
		if (p == null) return null;
		
		PaiementDTO dto = new PaiementDTO();
		dto.setLibelle(p.getLibelle());
		dto.setDate_paiement(p.getDatePaiement());
		dto.setType_paiement(p.getTypePaiement());
		dto.setStatut(p.getStatut());
        return dto;

	}
	
	public static Paiement toEntity(PaiementDTO dto) {
		  if (dto == null) return null;
		  
		Paiement p = new Paiement();
		p.setLibelle(dto.getLibelle());
		p.setDatePaiement(dto.getDate_paiement());
		p.setTypePaiement(dto.getType_paiement());
		p.setStatut(dto.getStatut());
		return p;
	}
}
