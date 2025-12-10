package bts.sio.azurimmo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import bts.sio.azurimmo.model.dto.BatimentDTO;
import bts.sio.azurimmo.service.BatimentService;

@RestController
public class BatimentController {

    @Autowired
    private BatimentService batimentService;  

    @GetMapping("api/batiments/{batimentId}")
    public Optional<BatimentDTO> getBatimentDTO(@PathVariable long batimentId) {
        return batimentService.getBatimentDTO(batimentId); 
    }
    
    @GetMapping("/re/{batimentId}")
    public ResponseEntity<BatimentDTO> getBatimentReDTO(@PathVariable long batimentId) {
            return batimentService.getBatimentDTO(batimentId)
                                  .map(ResponseEntity::ok)  
                                  .orElse(ResponseEntity.notFound().build()); 
    }
    
    @GetMapping("/")
    public List<BatimentDTO> getAllBatiments() {
        return batimentService.getBatimentsDTO(); 
    }
}
