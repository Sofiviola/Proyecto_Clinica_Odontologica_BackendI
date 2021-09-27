package com.clinica.odontologica.controller;


import com.clinica.odontologica.model.DTO.PacienteDTO;
import com.clinica.odontologica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {


    //Inyeccion dependecia
    @Autowired
    IPacienteService iPacienteService;


    //Para agregar un paciente
    @PostMapping()
    public ResponseEntity<?> agregarPaciente(@RequestBody PacienteDTO pacienteDTO){
        iPacienteService.agregarPaciente(pacienteDTO);
        return  ResponseEntity.status(HttpStatus.OK).body("Se agrego el paciente");
    }

    //Para buscar un paciente
    @GetMapping("/{id}")
    public PacienteDTO consultarPaciente(@PathVariable Long id){
        return iPacienteService.consultarPaciente(id);
    }

    //Para modificar un paciente
    @PutMapping()
    public ResponseEntity<?> modificarPaciente(@RequestBody PacienteDTO pacienteDTO){
        iPacienteService.modificarPaciente(pacienteDTO);
        return  ResponseEntity.status(HttpStatus.OK).body("Se modifico el paciente");
    }

    //Para borrar un paciente
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarPaciente(@PathVariable Long id){
        iPacienteService.borrarPaciente(id);
        return ResponseEntity.status(HttpStatus.OK).body("Se elimino el paciente");
    }

    //Listar los pacientes
    @GetMapping("/list")
    public Collection<PacienteDTO> listarPacientes(){
        return iPacienteService.getAll();
    }

}
