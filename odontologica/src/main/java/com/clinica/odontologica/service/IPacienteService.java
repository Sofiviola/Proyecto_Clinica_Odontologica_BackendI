package com.clinica.odontologica.service;

import com.clinica.odontologica.model.DTO.OdontologoDTO;
import com.clinica.odontologica.model.DTO.PacienteDTO;
import com.clinica.odontologica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface IPacienteService {

    void agregarPaciente(PacienteDTO pacienteDTO);

    PacienteDTO consultarPaciente(Long id);

    void modificarPaciente(PacienteDTO pacienteDTO);

    void borrarPaciente(Long id);

    Collection<PacienteDTO> getAll();

}
