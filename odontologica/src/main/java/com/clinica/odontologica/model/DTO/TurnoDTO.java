package com.clinica.odontologica.model.DTO;

import com.clinica.odontologica.model.Odontologo;
import com.clinica.odontologica.model.Paciente;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class TurnoDTO {

    private Long id;
    private Date fechaHoraTurno;
    private Paciente paciente;
    private Odontologo odontologo;

}
