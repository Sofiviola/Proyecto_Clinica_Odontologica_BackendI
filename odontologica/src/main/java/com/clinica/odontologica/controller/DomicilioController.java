package com.clinica.odontologica.controller;

import com.clinica.odontologica.model.DTO.DomicilioDTO;
import com.clinica.odontologica.model.DTO.OdontologoDTO;
import com.clinica.odontologica.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    //Inyeccion dependecia
    @Autowired
    IDomicilioService iDomicilioService;

    //Para agregar un domicilio
    @PostMapping()
    public ResponseEntity<?> agregarDomicilio(@RequestBody DomicilioDTO domicilioDTO){
        iDomicilioService.agregarDomicilio(domicilioDTO);
        return  ResponseEntity.status(HttpStatus.OK).body("Se agrego el domicilio");
    }
    //Listar los domicilios
    @GetMapping("/list")
    public Collection<DomicilioDTO> listarDomicilios(){
        return iDomicilioService.getAll();
    }
}
