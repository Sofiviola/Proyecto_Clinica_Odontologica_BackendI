package com.clinica.odontologica.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "turnos")
@Getter
@Setter
public class Turno {
 //Atributos
    @Id
    @GeneratedValue
    private Long id;
    private Date fechaHoraTurno;

    //Vinculacion tabla pacientes
    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    //Vinculacion tabla odontologos
    @ManyToOne
    @JoinColumn(name = "odontologo_id", nullable = false)
    private Odontologo odontologo;

}