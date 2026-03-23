package bts.sio.azurimmo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocataireDTO {
    private Long id; 
    private String nom;
    private String prenom;
    private String numeroTel;
    private String mail;
    private String iban;
    private String situation;
   
}