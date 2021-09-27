package com.clinica.odontologica.service;

import com.clinica.odontologica.model.DTO.OdontologoDTO;

import java.util.Collection;

public interface IOdontologoService {

    //CRUD odontologo
    void agregarOdontologo(OdontologoDTO odontologoDTO);

    OdontologoDTO consultarOdontologo(Long id);

    void modificarOdontologo(OdontologoDTO odontologoDTO);

    void borrarOdontologo(Long id);

    Collection<OdontologoDTO> getAll();

}
