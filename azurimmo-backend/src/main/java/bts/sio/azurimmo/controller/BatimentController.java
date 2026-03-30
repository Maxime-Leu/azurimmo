package bts.sio.azurimmo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import bts.sio.azurimmo.dto.BatimentDTO;
import bts.sio.azurimmo.service.BatimentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/batiments")
@CrossOrigin(origins = "http://localhost:5173") // 👈 INDISPENSABLE pour que React puisse parler au Back
@Tag(name = "Bâtiments", description = "API pour la gestion des bâtiments")
public class BatimentController {

    @Autowired
    private BatimentService batimentService;

    // On enlève le "/" pour que l'URL soit juste /api/batiments
    @GetMapping
    @Operation(summary = "Lister tous les bâtiments")
    public List<BatimentDTO> getAllBatiments() {
        return batimentService.getBatimentsDTO();
    }

    // Idem ici, on simplifie
    @PostMapping
    @Operation(summary = "Ajouter un bâtiment")
    public ResponseEntity<BatimentDTO> createBatiment(@RequestBody BatimentDTO dto) {
        BatimentDTO savedDTO = batimentService.saveBatimentDTO(dto);
        return ResponseEntity.status(201).body(savedDTO);
    }

    @GetMapping("/{batimentId}")
    @Operation(summary = "Consulter un bâtiment")
    public ResponseEntity<BatimentDTO> getBatimentReDTO(@PathVariable long batimentId) {
        return batimentService.getBatimentDTO(batimentId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}