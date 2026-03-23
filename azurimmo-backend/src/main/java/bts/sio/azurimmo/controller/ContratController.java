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

import bts.sio.azurimmo.model.Contrat;
import bts.sio.azurimmo.dto.ContratDTO;
import bts.sio.azurimmo.service.ContratService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/contrats")
@Tag(name = "Contrat", description = "API pour la gestion des contrats")
public class ContratController {
	
   @Autowired
    private ContratService contratService;

   
   @GetMapping("/")
   @Operation(summary = "Lister tous les contrats")
   public List<ContratDTO> getAllContrats() {
       return contratService.getContratsDTO(); 
   }
	
    @PostMapping("/")
    @Operation(summary = "Ajouter un contrat")
    public Contrat createContrat(@RequestBody Contrat contrat) {
        return contratService.saveContrat(contrat);
    }
    
 
    @GetMapping("/{contratId}")
    @Operation(summary = "Consulter un Contrat")
    public ResponseEntity<ContratDTO> getContratReDTO(@PathVariable long contratId) {
            return contratService.getContratDTO(contratId)
                                  .map(ResponseEntity::ok)  
                                  .orElse(ResponseEntity.notFound().build()); 
    }
    
    @GetMapping("/appartement/{appartementId}")
    @Operation(summary = "Lister les contrats d'un appartement")
    public List<ContratDTO> getContratsParAppartement(@PathVariable long appartementId) {
            return contratService.getContratParAppartement(appartementId);
     }
}