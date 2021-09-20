package com.clinica.odontologica.controller;


import com.clinica.odontologica.model.DTO.OdontologoDTO;
import com.clinica.odontologica.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    //Para que se inyecte la dependecia
    @Autowired
    IOdontologoService iOdontologoService;

    //Constructor
    public OdontologoController(IOdontologoService iOdontologoService) {
        this.iOdontologoService = iOdontologoService;
    }

    //Para agregar un odontologo
    @PostMapping()
    public ResponseEntity<OdontologoDTO> agregarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        iOdontologoService.agregarOdontologo(odontologoDTO);
        return  ResponseEntity.ok(null);
    }

    //Para buscar un odontologo
    @GetMapping("/{id}")
    public OdontologoDTO getOdontologo(@PathVariable Long id){
        return iOdontologoService.consultarOdontologo(id);
    }

    //Para modificar un odontologo
    @PutMapping()
    public ResponseEntity<OdontologoDTO> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        iOdontologoService.modificarOdontologo(odontologoDTO);
        return  ResponseEntity.ok(null);
    }

    //Para borrar un odontologo
    @DeleteMapping("/{id}")
    public ResponseEntity<OdontologoDTO> borrarOdontologo(@PathVariable Long id){
        iOdontologoService.borrarOdontologo(id);
        return ResponseEntity.ok(null);
    }

    //Listar los odontologos
    @GetMapping("/list")
    public Collection<OdontologoDTO> listarOdontologos(){
        return iOdontologoService.getAll();
    }

}
