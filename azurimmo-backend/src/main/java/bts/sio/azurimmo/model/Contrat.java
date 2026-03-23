package bts.sio.azurimmo.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "contrat")
public class Contrat {

	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;

	 @Column(name="libelle")
	 private String libelle; 

	 @Column(name="date_debut")
	 private LocalDate dateDebut;
	 
	 @Column(name="date_fin") 
	 private LocalDate dateFin;
	 
	 @Column(name="montant_brut") 
	 private float montantBrut;
	 
	 @Column(name="montant_charges") 
	 private float montantCharges;
	 
	 @ManyToOne 
	 @JoinColumn(name = "appartement_id") 
	 private Appartement appartement;

     @ManyToMany
     @JoinTable(
        name = "contrat_locataire",
        joinColumns = @JoinColumn(name = "contrat_id"),
        inverseJoinColumns = @JoinColumn(name = "locataire_id")
     )
     private List<Locataire> locataires;
}