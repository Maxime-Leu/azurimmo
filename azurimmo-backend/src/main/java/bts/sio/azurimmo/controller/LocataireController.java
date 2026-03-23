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

import bts.sio.azurimmo.model.Locataire;
import bts.sio.azurimmo.dto.LocataireDTO;
import bts.sio.azurimmo.service.LocataireService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/locataires")
@Tag(name = "Locataire", description = "API pour la gestion des locataires")
public class LocataireController {
	
   @Autowired
    private LocataireService locataireService;

   
   @GetMapping("/")
   @Operation(summary = "Lister tous les locataires")
   public List<LocataireDTO> getAllLocataires() {
       return locataireService.getLocatairesDTO(); 
   }
	
    @PostMapping("/")
    @Operation(summary = "Ajouter un locataire")
    public Locataire createLocataire(@RequestBody Locataire locataire) {
        return locataireService.saveLocataire(locataire);
    }
    
 
    @GetMapping("/{locataireId}")
    @Operation(summary = "Consulter un Locataire par ID")
    public ResponseEntity<LocataireDTO> getLocataireDTOById(@PathVariable long locataireId) {
            return locataireService.getLocataireDTO(locataireId)
                                  .map(ResponseEntity::ok)  
                                  .orElse(ResponseEntity.notFound().build()); 
    }
    
 
    @GetMapping("/contrat/{contratId}") 
    @Operation(summary = "Lister les locataires d'un contrat")
    public List<LocataireDTO> getLocatairesParContrat(@PathVariable long contratId) { 
            return locataireService.getLocataireParContrat(contratId);
     }
}