package com.telefonia.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/telefonia")
public class TelefoniaController {
    // Sin uso 
    
    @GetMapping("/coords")
    public ResponseEntity<?> getTelefoniaByCoords(@RequestParam float lon, @RequestParam float lat){
        // TODO Validar coordenadas
        return ResponseEntity.ok().body("Coordenadas validadas");
    }
    @GetMapping("/direc")
    public ResponseEntity<?> getTelefoniaByDirec(@RequestParam String cp, @RequestParam String mpio, @RequestParam String edo){
        // TODO Validar dirección
        return ResponseEntity.ok().body("Dirección validada");
    }

}
