package com.clinica.odontologica.model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;
}
