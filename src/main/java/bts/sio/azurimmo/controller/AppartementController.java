package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Appartement;
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
	public  List<Appartement> getAppartements() {
	        return appartementService.getAppartements();
	}
	
    @PostMapping("/")
    public Appartement createAppartement(@RequestBody Appartement appartement) {
        return appartementService.saveAppartement(appartement);
    }
    
    @GetMapping("/ville/{ville}")
    public List<Appartement> findByVille(@PathVariable String ville) {
        return appartementService.findByVille(ville);
    }
    
    @GetMapping("/batiment/{batimentId}")
    public List<Appartement> getAppartementsParBatiment(@PathVariable long batimentId) {
            return appartementService.getAppartementsParBatiment(batimentId);
            
    }
    
    @GetMapping("/superieur/{surface}")
    public List<Appartement> getAppartementsSuperieur(@PathVariable float surface) {
            return appartementService.getAppartementsSuperieur(surface);
            
    }
    
    
}