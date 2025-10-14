package com.telefonia.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telefonia.Entities.Colonia;
import com.telefonia.Entities.Estado;
import com.telefonia.Entities.Municipio;
import com.telefonia.controllers.dto.ColoniaDTO;
import com.telefonia.controllers.dto.EstadoDTO;
import com.telefonia.controllers.dto.MunicipioDTO;
import com.telefonia.service.IColoniaService;
import com.telefonia.service.IEstadoService;
import com.telefonia.service.IMunicipioService;

@RestController
@RequestMapping("/api/direccion")
public class DireccionController {
    @Autowired
    private IEstadoService estadoService;
    @Autowired
    private IColoniaService coloniaService;
    @Autowired
    private IMunicipioService municipioService;

    @GetMapping("/estado")
    /*
     * Función que retorna todos los estados con una lista de sus municipios
     * @return Lista de Estados
    */
    public ResponseEntity<?> findAll(){
        List<EstadoDTO> estadoList = estadoService.findAll()
        .stream()
        .map(estado -> EstadoDTO.builder()
            .clave(estado.getClave())
            .nombre(estado.getNombre())
            .abreviacion(estado.getAbreviacion())
            .cpMin(estado.getCpMin())
            .cpMax(estado.getCpMax())
            .municipios(estado.getMunicipios())
            .build())
        .toList();
        return ResponseEntity.ok(estadoList);
    }
    /**
     * Funciones que regresan un estado, municipio o colonia dado un id
     * @param id
     * @return DTO
    */
    @GetMapping("/estado/{id}")
    public ResponseEntity<?> getEstadoById(@PathVariable Byte id){
        // Buscamos por ID
        Optional<Estado> estadoOptional = estadoService.findById(id);
        if(estadoOptional.isPresent()){
            Estado estado = estadoOptional.get();
            EstadoDTO estadoDTO = EstadoDTO.builder()
                .clave(estado.getClave())
                .nombre(estado.getNombre())
                .abreviacion(estado.getAbreviacion())
                .cpMin(estado.getCpMin())
                .cpMax(estado.getCpMax())
                .municipios(estado.getMunicipios())
                .coberturaEstado(estado.getCoberturaEstado())
                .build();
                // retornamos un DTO
            return ResponseEntity.ok().body(estadoDTO);
        }
        // Si no se encuentra mandamos 404 not found
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/municipio/{id}")
    public ResponseEntity<?> getMunicipioById(@PathVariable Integer id) {
        Optional<Municipio> municipiOptional = municipioService.findById(id);
        if (municipiOptional.isPresent()) {
            Municipio municipio = municipiOptional.get();
            MunicipioDTO municipioDTO = MunicipioDTO.builder()
                    .id(municipio.getId())
                    .nombre(municipio.getNombre())
                    .cpMin(municipio.getCpMin())
                    .cpMax(municipio.getCpMax())
                    .husoHorario(MunicipioDTO.HusoHorario.valueOf(municipio.getHusoHorario().name()))
                    .estado(municipio.getEstado())
                    .colonias(municipio.getColonias())
                    .coberturaMunicipio(municipio.getCoberturaMunicipio())
                    .build();
            return ResponseEntity.ok().body(municipioDTO);
        }
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/colonia/{id}")
    public ResponseEntity<?> getColoniaById(@PathVariable Integer id){
        Optional<Colonia> coloniaOptional = coloniaService.findById(id);
        if(coloniaOptional.isPresent()){
            Colonia colonia = coloniaOptional.get();
            ColoniaDTO coloniaDTO = ColoniaDTO.builder()
                .id(colonia.getId())
                .nombre(colonia.getNombre())
                .asentamiento(colonia.getAsentamiento())
                .codigoPostal(colonia.getCodigoPostal())
                .latitud(colonia.getLatitud())
                .longitud(colonia.getLongitud())
                .municipio(colonia.getMunicipio())
                .coberturaColonia(colonia.getCoberturaColonia())
                .build();
            return ResponseEntity.ok().body(coloniaDTO);
        }
        return ResponseEntity.notFound().build();
    }

    


}
