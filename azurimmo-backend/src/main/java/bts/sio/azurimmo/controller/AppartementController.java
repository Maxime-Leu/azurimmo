package bts.sio.azurimmo.controller;

import bts.sio.azurimmo.model.Appartement;
import bts.sio.azurimmo.service.AppartementService;
import bts.sio.azurimmo.dto.AppartementDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/appartements")
@CrossOrigin(origins = "http://localhost:5173") // 👈 1. INDISPENSABLE pour que React (5173) puisse appeler le Back (9008)
@Tag(name = "Appartement", description = "API pour la gestion des appartements")
public class AppartementController {

    @Autowired
    private AppartementService appartementService;

    // 👈 2. LA MÉTHODE MANQUANTE : Elle gère l'URL http://localhost:9008/api/appartements
    @GetMapping
    @Operation(summary = "Lister TOUS les appartements")
    public List<AppartementDTO> getAllAppartements() {
        // Vérifie que cette méthode existe dans ton appartementService (Java)
        return appartementService.getAppartementsDTO();
    }

    @PostMapping
    @Operation(summary = "Ajouter un appartement")
    public Appartement createAppartement(@RequestBody Appartement appartement) {
        return appartementService.saveAppartement(appartement);
    }

    @GetMapping("/ville/{ville}")
    @Operation(summary = "Lister tous les appartements d'une ville")
    public List<AppartementDTO> findByVille(@PathVariable String ville) {
        return appartementService.findByVille(ville);
    }

    @GetMapping("/batiment/{batimentId}")
    @Operation(summary = "Lister tous les appartements d'un batiment")
    public List<AppartementDTO> getAppartementsParBatiment(@PathVariable long batimentId) {
        return appartementService.getAppartementsParBatiment(batimentId);
    }

    @GetMapping("/surfaceGreaterThan/{surface}")
    @Operation(summary = "Lister tous les appartements ayant une certaine surface")
    public List<AppartementDTO> findAppartementsBySurfaceGreaterThan(@PathVariable float surface) {
        return appartementService.findAppartementsBySurfaceGreaterThan(surface);
    }
}