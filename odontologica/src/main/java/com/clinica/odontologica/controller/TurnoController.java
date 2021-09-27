package com.clinica.odontologica.controller;


import com.clinica.odontologica.model.DTO.TurnoDTO;
import com.clinica.odontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/turnos")
public class TurnoController {


    //Inyeccion dependecia
    @Autowired
    ITurnoService iTurnoService;

    //Para agregar un turno
    @PostMapping()
    public ResponseEntity<?> agregarTurno (@RequestBody TurnoDTO turnoDTO){
        iTurnoService.agregarTurno(turnoDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Se agrego el turno");
    }

    //Listar los turnos
    @GetMapping("/list")
    public Collection<TurnoDTO> listaTurnos(){
        return iTurnoService.getAll();
    }
}
