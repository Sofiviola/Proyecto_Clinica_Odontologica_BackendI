package com.clinica.odontologica.service;

import com.clinica.odontologica.model.DTO.PacienteDTO;

import java.util.Collection;

public interface IPacienteService {

    //CRUD paciente

    void agregarPaciente(PacienteDTO pacienteDTO);

    PacienteDTO consultarPaciente(Long id);

    void modificarPaciente(PacienteDTO pacienteDTO);

    void borrarPaciente(Long id);

    Collection<PacienteDTO> getAll();
}
