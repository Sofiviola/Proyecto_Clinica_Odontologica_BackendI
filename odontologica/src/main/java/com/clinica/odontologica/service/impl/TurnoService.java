package com.clinica.odontologica.service.impl;


import com.clinica.odontologica.model.DTO.TurnoDTO;
import com.clinica.odontologica.model.Turno;
import com.clinica.odontologica.repository.ITurnoRepository;
import com.clinica.odontologica.service.ITurnoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService {

    //Inyeccion dependecias
    @Autowired
    ITurnoRepository iTurnoRepository;

    @Autowired
    ObjectMapper mapper;


    //Implementacion metodos interface

    @Override
    public void agregarTurno(TurnoDTO turnoDTO) {
        Turno turno = mapper.convertValue(turnoDTO, Turno.class);
        iTurnoRepository.save(turno);
    }

    @Override
    public Collection<TurnoDTO> getAll() {
        List<Turno> turnos = iTurnoRepository.findAll();

        Set<TurnoDTO> turnosDTO = new HashSet<>();
        for(Turno turno : turnos){
            turnosDTO.add(mapper.convertValue(turno,TurnoDTO.class));

        }
        return turnosDTO;

    }
}
