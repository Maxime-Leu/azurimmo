package bts.sio.azurimmo.dto;

import java.time.LocalDate;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContratDTO {
	private String libelle;
	private LocalDate date_debut;
	private LocalDate date_fin;
	private Float montant_brut;
	private Float montant_charges;
	
	
    private List<LocataireDTO> locataires;
    private AppartementDTO appartement; 
}
