package bts.sio.azurimmo.model;

import jakarta.persistence.*;
import jakarta.persistence.OneToMany;
import lombok.Data;
import java.util.List; 

@Data
@Entity
@Table(name = "batiment")
public class Batiment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="adresse")
    private String adresse;

    @Column(name="ville")
    private String ville;


    @OneToMany(mappedBy = "batiment")
    private List<Appartement> appartements;
}