package com.telefonia.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telefonia.controllers.dto.ClienteDTO;

@RestController
@RequestMapping("/api/client")
public class ClienteController {
    // TODO validar todo alv
    // Sin uso
    @GetMapping()   // Operaciones que se mapea directamente con /api/client
    public ResponseEntity<?> getClients(){
        return ResponseEntity.ok().body("Hay te van todos los clientes");
    }
    @PostMapping()
    public ResponseEntity<?> postClient(@RequestBody ClienteDTO clienteDTO) throws URISyntaxException{
        if(clienteDTO.getNombre().isBlank()){
            return ResponseEntity.badRequest().build();
        }
        /*
         * La ruta /api/client/save es probablemente el endpoint donde se realizó la
         * operación de guardado. Sin embargo, lo más común es que el Location apunte a
         * la URI única del recurso creado, por ejemplo /api/client/{id}. Usar
         * /api/client/save puede ser confuso, porque no representa el recurso
         * específico, sino el endpoint de la acción.
         * 
         * Recomendación: Si tienes acceso al ID del cliente recién creado, sería mejor
         * construir la URI así:
         * 
         * Así el cliente sabrá exactamente dónde consultar el nuevo recurso.
         */
        return ResponseEntity.created(new URI("/api/client/save")).build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getClientById(@PathVariable int id){
        return ResponseEntity.ok().body("Hay te va el cliente con el id " + id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<?> putClient(@PathVariable int id, @RequestBody ClienteDTO clienteDTO){
        if (clienteDTO.getNombre().isBlank()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body("Se ha actualizado el cliente con id " + id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@PathVariable int id){
        return ResponseEntity.ok().body("Se ha eliminado el cliente con id " + id);
    }
}
