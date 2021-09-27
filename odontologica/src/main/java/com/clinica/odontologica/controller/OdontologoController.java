package com.clinica.odontologica.controller;


import com.clinica.odontologica.model.DTO.OdontologoDTO;
import com.clinica.odontologica.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    //Inyeccion dependecia
    @Autowired
    IOdontologoService iOdontologoService;

    public OdontologoController(IOdontologoService iOdontologoService) {
        this.iOdontologoService = iOdontologoService;
    }

    //Para agregar un odontologo
    @PostMapping()
    public ResponseEntity<?> agregarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        iOdontologoService.agregarOdontologo(odontologoDTO);
        return  ResponseEntity.status(HttpStatus.OK).body("Se agrego el odontologo");
    }

    //Para buscar un odontologo
    @GetMapping("/{id}")
    public OdontologoDTO consultarOdontologo(@PathVariable long id){
        return iOdontologoService.consultarOdontologo(id);
    }

    //Para modificar un odontologo
    @PutMapping()
    public ResponseEntity<?> modificarOdontologo(@RequestBody OdontologoDTO odontologoDTO){
        iOdontologoService.modificarOdontologo(odontologoDTO);
        return  ResponseEntity.status(HttpStatus.OK).body("Se modifico el odontologo");
    }

    //Para borrar un odontologo
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarOdontologo(@PathVariable long id){
        iOdontologoService.borrarOdontologo(id);
        return ResponseEntity.status(HttpStatus.OK).body("Se elimino el odontologo");
    }

    //Listar los odontologos
    @GetMapping("/list")
    public Collection<OdontologoDTO> listarOdontologos(){
        return iOdontologoService.getAll();
    }

}
