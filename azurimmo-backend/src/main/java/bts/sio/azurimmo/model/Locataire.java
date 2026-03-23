package bts.sio.azurimmo.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "locataire")
public class Locataire {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 @Column(name="prenom")
	 private String prenom; 
	 
	 @Column(name="nom")
	 private String nom; 
	 
	 @Column(name="numero_tel")
	 private String numeroTel; 
	 
	 @Column(name="mail")
	 private String mail; 
	 
	 @Column(name="iban")
	 private String iban; 
	 
	 @Column(name="situation")
	 private String situation; 


	 @ManyToMany(mappedBy = "locataires")
	 private List<Contrat> contrats; 
}