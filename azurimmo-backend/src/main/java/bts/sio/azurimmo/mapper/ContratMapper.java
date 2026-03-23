package bts.sio.azurimmo.mapper;


import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.dto.ContratDTO;

public class ContratMapper {
	
	public static ContratDTO toDTO(Contrat c) {
		 if (c == null) return null;
		 
		 	ContratDTO dto = new ContratDTO();
	        dto.setLibelle(c.getLibelle()); 
	        dto.setDate_debut(c.getDateDebut());
	        dto.setDate_fin(c.getDateFin());
	        dto.setMontant_brut(c.getMontantBrut());
	        dto.setMontant_charges(c.getMontantCharges());
	        return dto;
	}
	
    public static Contrat toEntity(ContratDTO dto) {
        if (dto == null) return null;

        Contrat c = new Contrat();
        c.setLibelle(dto.getLibelle());
        c.setDateDebut(dto.getDate_debut());
        c.setDateFin(dto.getDate_fin());
        c.setMontantBrut(dto.getMontant_brut());
        c.setMontantCharges(dto.getMontant_charges());
        return c;
        
    }

}