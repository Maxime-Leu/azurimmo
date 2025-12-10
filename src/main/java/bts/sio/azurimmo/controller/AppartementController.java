package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.model.dto.AppartementDTO;
import bts.sio.azurimmo.service.AppartementService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appartements")
@Tag(name = "Appartements", description = "Gestion des appartements")
public class AppartementController {
	
   @Autowired
    private AppartementService appartementService;
   
    @GetMapping
	@Operation(summary = "Récupère tous les appartements")
	public  List<AppartementDTO> getAppartements() {
	        return appartementService.getAppartements();
	}
    
    @Operation(summary = "Permet d'ajouter un appartement.")
    @PostMapping("/")
    public AppartementDTO createAppartement(@RequestBody AppartementDTO dto) {
        return appartementService.saveAppartement(dto);
    }
    
    @Operation(summary = "Permet de trouver un appartement de par sa ville.")
    @GetMapping("/ville/{ville}")
    public List<AppartementDTO> findByVille(@PathVariable String ville) {
        return appartementService.findByVille(ville);
    }
    
    @Operation(summary = "Trouve un appartement par rapport a son batiment.")
    @GetMapping("/batiment/{batimentId}")
    public List<AppartementDTO> getAppartementsParBatiment(@PathVariable long batimentId) {
            return appartementService.getAppartementsParBatiment(batimentId);
            
    }
    
    @Operation(summary = "Trouve un appartement supérieur en terme de surface a la valeur choisie.")
    @GetMapping("/superieur/{surface}")
    public List<AppartementDTO> getAppartementsSuperieur(@PathVariable float surface) {
            return appartementService.getAppartementsSuperieur(surface);
            
    }
    
    
}