package com.clinica.odontologica.repository;

import com.clinica.odontologica.model.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteRepository extends JpaRepository <Paciente, Long> {

}
