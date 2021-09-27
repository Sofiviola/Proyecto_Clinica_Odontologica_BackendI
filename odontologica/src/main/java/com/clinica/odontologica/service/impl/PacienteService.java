package com.clinica.odontologica.service.impl;


import com.clinica.odontologica.model.DTO.PacienteDTO;
import com.clinica.odontologica.model.Paciente;
import com.clinica.odontologica.repository.IPacienteRepository;
import com.clinica.odontologica.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PacienteService implements IPacienteService {

    //Inyeccion dependecias
    @Autowired
    IPacienteRepository iPacienteRepository;

    @Autowired
    ObjectMapper mapper;


    //Implementacion metodos interface
    @Override
    public void agregarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        iPacienteRepository.save(paciente);
    }

    @Override
    public PacienteDTO consultarPaciente(Long id) {
        Optional<Paciente> paciente = iPacienteRepository.findById(id);
        return mapper.convertValue(paciente, PacienteDTO.class);
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = mapper.convertValue(pacienteDTO, Paciente.class);
        iPacienteRepository.save(paciente);
    }

    @Override
    public void borrarPaciente(Long id) {
        iPacienteRepository.deleteById(id);
    }

    @Override
    public Collection<PacienteDTO> getAll() {
        List<Paciente> pacientes = iPacienteRepository.findAll();
        Set<PacienteDTO> pacientesDTO = new HashSet<>();
        for (Paciente paciente: pacientes) {
            pacientesDTO.add( mapper.convertValue(paciente,PacienteDTO.class));
        }
        return pacientesDTO;
    }





}
