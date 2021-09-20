package com.clinica.odontologica.service.impl;

import com.clinica.odontologica.model.DTO.PacienteDTO;
import com.clinica.odontologica.model.Paciente;
import com.clinica.odontologica.repository.IPacienteRepository;
import com.clinica.odontologica.service.IPacienteService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class PacienteServiceImpl implements IPacienteService {
    //
    @Autowired
    IPacienteRepository iPacienteRepository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    ModelMapper modelMapper;

    //Implementacion metodos interface
    @Override
    public void agregarPaciente(PacienteDTO pacienteDTO) {
        guardarPaciente(pacienteDTO);
    }

    @Override
    public PacienteDTO consultarPaciente(Long id) {
        Optional<Paciente> encontrar = iPacienteRepository.findById(id);
        return mapper.convertValue(encontrar, PacienteDTO.class);
    }

    @Override
    public void modificarPaciente(PacienteDTO pacienteDTO) {
        guardarPaciente(pacienteDTO);
    }

    @Override
    public void borrarPaciente(Long id) {
        iPacienteRepository.deleteById(id);
    }

    @Override
    public Collection<PacienteDTO> getAll() {
        Collection <Paciente> allPacientes = iPacienteRepository.findAll(Sort.by(Sort.Direction.ASC, "apellido"));
        return modelMapper.map(allPacientes, new TypeToken<List<PacienteDTO>>() {}.getType());
    }

    //Metodo creado para agregar y modificar odontologo
    private void guardarPaciente(PacienteDTO pacienteDTO){
        Paciente newPaciente = mapper.convertValue(pacienteDTO, Paciente.class);
        iPacienteRepository.save(newPaciente);
    }

}
