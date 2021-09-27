package com.clinica.odontologica.service.impl;
import com.clinica.odontologica.model.DTO.OdontologoDTO;
import com.clinica.odontologica.model.Odontologo;
import com.clinica.odontologica.repository.IOdontologoRepository;
import com.clinica.odontologica.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class OdontologoService implements IOdontologoService {

    //Inyeccion dependecias
    @Autowired
    IOdontologoRepository iOdontologoRepository;

    @Autowired
    ObjectMapper mapper;

    //Implementacion metodos interface
    @Override
    public void agregarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        iOdontologoRepository.save(odontologo);
    }

    @Override
    public OdontologoDTO consultarOdontologo(Long id) {
        Optional<Odontologo> odontologo = iOdontologoRepository.findById(id);
        return mapper.convertValue(odontologo, OdontologoDTO.class);
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        Odontologo odontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        iOdontologoRepository.save(odontologo);
    }

    @Override
    public void borrarOdontologo(Long id) {
    iOdontologoRepository.deleteById(id);
    }

    @Override
    public Collection<OdontologoDTO> getAll() {
        List<Odontologo> odontologos = iOdontologoRepository.findAll();
        Set<OdontologoDTO> odontologosDTO = new HashSet<>();
        for (Odontologo odontologo : odontologos) {
            odontologosDTO.add(mapper.convertValue(odontologo,OdontologoDTO.class));
        }
        return odontologosDTO;
    }
}

