package com.clinica.odontologica.controller;


import com.clinica.odontologica.model.DTO.PacienteDTO;
import com.clinica.odontologica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")

public class PacienteController {

    //Para que se inyecte la dependecia
    @Autowired
    IPacienteService iPacienteService;

    //Constructor
    public PacienteController(IPacienteService iPacienteService) {
        this.iPacienteService = iPacienteService;
    }
    //Para agregar un paciente
    @PostMapping()
    public ResponseEntity<PacienteDTO> agregarPaciente(@RequestBody PacienteDTO pacienteDTO){
        iPacienteService.agregarPaciente(pacienteDTO);
        return  ResponseEntity.ok(null);
    }

    //Para buscar un paciente
    @GetMapping("/{id}")
    public PacienteDTO getPaciente(@PathVariable Long id){
        return iPacienteService.consultarPaciente(id);
    }

    //Para modificar un paciente
    @PutMapping()
    public ResponseEntity<PacienteDTO> modificarPaciente(@RequestBody PacienteDTO pacienteDTO){
        iPacienteService.modificarPaciente(pacienteDTO);
        return  ResponseEntity.ok(null);
    }

    //Para borrar un paciente
    @DeleteMapping("/{id}")
    public ResponseEntity<PacienteDTO> borrarPaciente(@PathVariable Long id){
        iPacienteService.borrarPaciente(id);
        return ResponseEntity.ok(null);
    }

    //Listar los pacientes
    @GetMapping("/list")
    public Collection<PacienteDTO> listarPacientes(){
        return iPacienteService.getAll();
    }


}
