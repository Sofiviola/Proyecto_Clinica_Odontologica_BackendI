package com.clinica.odontologica.service;


import com.clinica.odontologica.model.DTO.TurnoDTO;


import java.util.Collection;

public interface ITurnoService {

    //CRUD Turno

    void agregarTurno(TurnoDTO turnoDTO);

    Collection<TurnoDTO> getAll();
}
