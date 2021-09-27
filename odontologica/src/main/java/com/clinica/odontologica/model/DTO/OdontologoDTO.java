package com.clinica.odontologica.model.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class OdontologoDTO {

    private Long id;
    private String nombre;
    private String apellido;
    private Integer matricula;
}
