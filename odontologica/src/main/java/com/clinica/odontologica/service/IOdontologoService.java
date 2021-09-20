package com.clinica.odontologica.service;

import com.clinica.odontologica.model.DTO.OdontologoDTO;
import com.clinica.odontologica.model.Odontologo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public interface IOdontologoService {

    void agregarOdontologo(OdontologoDTO studentDTO);

    OdontologoDTO consultarOdontologo(Long id);

    void modificarOdontologo(OdontologoDTO odontologoDTO);

    void borrarOdontologo(Long id);

    Collection<OdontologoDTO> getAll();


}
