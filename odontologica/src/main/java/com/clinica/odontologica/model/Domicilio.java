package com.clinica.odontologica.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "domicilios")
@Getter
@Setter

public class Domicilio {
 //Atributos
    @Id
    @GeneratedValue
    private Long id;
    private String calle;
    private String numero;
    private String localidad;
    private String provincia;



}
