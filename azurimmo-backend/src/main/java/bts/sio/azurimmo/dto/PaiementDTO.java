package bts.sio.azurimmo.dto;

import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class PaiementDTO {

	private String libelle;
	private LocalDate date_paiement;
	private String type_paiement;
	private String statut;
}
