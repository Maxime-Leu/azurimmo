package bts.sio.azurimmo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import bts.sio.azurimmo.dto.BatimentDTO;
import bts.sio.azurimmo.service.BatimentService;

import io.swagger.v3.oas.annotations.Operation; // Import Swagger
import io.swagger.v3.oas.annotations.tags.Tag; 

@RestController
@RequestMapping("/api/batiments")
@Tag(name = "Bâtiments", description = "API pour la gestion des bâtiments")
public class BatimentController {

    @Autowired 
    private BatimentService batimentService; 
    
    @GetMapping("/")
    @Operation(summary = "Lister tous les bâtiments")
    public List<BatimentDTO> getAllBatiments() {
        return batimentService.getBatimentsDTO(); 
    }
    
    @PostMapping("/")
    @Operation(summary = "Ajouter un bâtiment")
    public ResponseEntity<BatimentDTO> createBatiment(@RequestBody BatimentDTO dto) {
        BatimentDTO savedDTO = batimentService.saveBatimentDTO(dto);
        return ResponseEntity.status(201).body(savedDTO); 
    }


/*    
    @GetMapping("/{batimentId}")
    public Optional <BatimentDTO> getBatimentDTO(@PathVariable long batimentId) {
        return batimentService.getBatimentDTO(batimentId);
    }
*/

    
    @GetMapping("/{batimentId}")
    @Operation(summary = "Consuter un bâtiment")
    public ResponseEntity<BatimentDTO> getBatimentReDTO(@PathVariable long batimentId) {
            return batimentService.getBatimentDTO(batimentId)
                                  .map(ResponseEntity::ok)   // batiment trouvé → 200
                                  .orElse(ResponseEntity.notFound().build()); // pas trouvé → 404
    }
}