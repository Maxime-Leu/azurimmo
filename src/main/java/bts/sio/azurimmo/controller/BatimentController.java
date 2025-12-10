package bts.sio.azurimmo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import bts.sio.azurimmo.model.dto.BatimentDTO;
import bts.sio.azurimmo.service.BatimentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Batiments", description = "Gestion des batiments")
@RestController
public class BatimentController {

    @Autowired
    private BatimentService batimentService;  
    
    
    @Operation(summary = "Récupère un batiment grace a son ID")
    @GetMapping("api/batiments/{batimentId}")
    public Optional<BatimentDTO> getBatimentDTO(@PathVariable long batimentId) {
        return batimentService.getBatimentDTO(batimentId); 
    }
    
    @Operation(summary = "Récupère un batiment grace a son ID")
    @GetMapping("/{batimentId}")
    public Optional <BatimentDTO> getBatimentDTO1(@PathVariable long batimentId) {
        return batimentService.getBatimentDTO(batimentId);
    }
    
    /*@GetMapping("/re/{batimentId}")
    public ResponseEntity<BatimentDTO> getBatimentReDTO(@PathVariable long batimentId) {
            return batimentService.getBatimentDTO(batimentId)
                                  .map(ResponseEntity::ok)  
                                  .orElse(ResponseEntity.notFound().build()); 
    }*/
    
    @Operation(summary = "Récupère tous les batiments")
    @GetMapping("/")
    public List<BatimentDTO> getAllBatiments() {
        return batimentService.getBatimentsDTO(); 
    }
    
    @Operation(summary = "Affiche tous les batiments ainsi que leurs appartements")
    @GetMapping("api/batiments/")
    public List<BatimentDTO> getAllBatiments1() {
        return batimentService.getBatimentsDTO(); 
    }
   
    @Operation(summary = "Permet d'ajouter un batiment")
    @PostMapping("/")
    public ResponseEntity<BatimentDTO> createBatiment(@RequestBody BatimentDTO dto) {
        BatimentDTO savedDTO = batimentService.saveBatimentDTO(dto);
        return ResponseEntity.status(201).body(savedDTO); 
    }
}
