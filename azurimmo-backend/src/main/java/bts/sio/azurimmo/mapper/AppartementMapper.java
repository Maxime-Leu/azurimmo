package bts.sio.azurimmo.mapper;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.dto.AppartementDTO; // <<< Import du DTO

public class AppartementMapper {

    public static AppartementDTO toDTO(Appartement a) {
        if (a == null) return null;

        AppartementDTO dto = new AppartementDTO();
        dto.setNumero(String.valueOf(a.getNumero())); 
        dto.setDescription(a.getDescription());
        dto.setSurface(a.getSurface());
        dto.setNbPieces(a.getNbPiecesPrincipales());
        return dto;
    }

    public static Appartement toEntity(AppartementDTO dto) {
        if (dto == null) return null;

        Appartement a = new Appartement();
        if(dto.getNumero() != null) {
             a.setNumero(Integer.parseInt(dto.getNumero()));
        }
        a.setDescription(dto.getDescription());
        a.setSurface(dto.getSurface());

        if(dto.getNbPieces() != null) {
            a.setNbPiecesPrincipales(dto.getNbPieces());
        }
        return a;
    }
}