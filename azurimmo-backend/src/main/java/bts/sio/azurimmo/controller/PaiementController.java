package bts.sio.azurimmo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bts.sio.azurimmo.model.Paiement;
import bts.sio.azurimmo.dto.PaiementDTO;
import bts.sio.azurimmo.service.PaiementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/paiements")
@Tag(name = "Paiement", description = "API pour la gestion des paiements")
public class PaiementController {
	
   @Autowired
    private PaiementService paiementService;

   
   @GetMapping("/")
   @Operation(summary = "Lister tous les paiements")
   public List<PaiementDTO> getAllPaiements() {
       return paiementService.getPaiementsDTO(); 
   }
	
    @PostMapping("/")
    @Operation(summary = "Ajouter un paiement")
    public Paiement createPaiement(@RequestBody Paiement paiement) {
        return paiementService.savePaiement(paiement);
    }
    
 
    @GetMapping("/{paiementId}")
    @Operation(summary = "Consulter un Paiement par ID")
    public ResponseEntity<PaiementDTO> getPaiementDTOById(@PathVariable long paiementId) {
            return paiementService.getPaiementDTO(paiementId)
                                  .map(ResponseEntity::ok)  
                                  .orElse(ResponseEntity.notFound().build()); 
    }
    
 
    @GetMapping("/contrat/{contratId}") 
    @Operation(summary = "Lister les paiements d'un contrat")
    public List<PaiementDTO> getPaiementParContrat(@PathVariable long contratId) {
            return paiementService.getPaiementParContrat(contratId);
     }
}