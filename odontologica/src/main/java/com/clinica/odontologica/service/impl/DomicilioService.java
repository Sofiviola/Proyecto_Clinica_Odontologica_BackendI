package com.clinica.odontologica.service.impl;

import com.clinica.odontologica.model.DTO.DomicilioDTO;
import com.clinica.odontologica.model.DTO.OdontologoDTO;
import com.clinica.odontologica.model.Domicilio;
import com.clinica.odontologica.model.Odontologo;
import com.clinica.odontologica.repository.IDomicilioRepository;
import com.clinica.odontologica.service.IDomicilioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DomicilioService implements IDomicilioService{

    //Inyeccion dependecias
    @Autowired
    IDomicilioRepository iDomicilioRepository;

    @Autowired
    ObjectMapper mapper;

    @Override
    public void agregarDomicilio(DomicilioDTO domicilioDTO) {
        Domicilio domicilio = mapper.convertValue(domicilioDTO, Domicilio.class);
        iDomicilioRepository.save(domicilio);
    }

    @Override
    public Collection<DomicilioDTO> getAll() {
            List<Domicilio> domicilios = iDomicilioRepository.findAll();
            Set<DomicilioDTO> domiciliosDTO = new HashSet<>();
            for (Domicilio domicilio : domicilios) {
                domiciliosDTO.add(mapper.convertValue(domicilio,DomicilioDTO.class));
            }
            return domiciliosDTO;
    }

}
