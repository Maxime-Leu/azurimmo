package bts.sio.azurimmo.mapper;

import bts.sio.azurimmo.model.Locataire;

import bts.sio.azurimmo.dto.LocataireDTO;


public class LocataireMapper {
	

	
	public static LocataireDTO toDTO(Locataire l) {
		if (l == null) return null;
		
		LocataireDTO dto = new LocataireDTO();
		dto.setPrenom(l.getPrenom());
		dto.setNom(l.getNom());
		dto.setNumeroTel(l.getNumeroTel());
		dto.setMail(l.getMail());
		dto.setIban(l.getIban());
		dto.setSituation(l.getSituation());
		return dto;

	}
	
	public static Locataire toEntity(LocataireDTO dto) {
		  if (dto == null) return null;
		  
		Locataire l = new Locataire();
		l.setPrenom(dto.getPrenom());
		l.setNom(dto.getNom());
		l.setNumeroTel(dto.getNumeroTel());
		l.setMail(dto.getMail());
		l.setIban(dto.getIban());
		l.setSituation(dto.getSituation());
		return l;
	}

}
