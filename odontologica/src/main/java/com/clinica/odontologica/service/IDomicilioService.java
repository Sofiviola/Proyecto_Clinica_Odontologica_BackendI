package com.clinica.odontologica.service;

import com.clinica.odontologica.model.DTO.DomicilioDTO;
import com.clinica.odontologica.model.DTO.OdontologoDTO;

import java.util.Collection;


public interface IDomicilioService {

    //CRUD Domicilio
    void agregarDomicilio(DomicilioDTO domicilioDTO);

    Collection<DomicilioDTO> getAll();
}
