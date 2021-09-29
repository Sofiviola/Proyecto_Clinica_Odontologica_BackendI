package com.clinica.odontologica.model;

import com.clinica.odontologica.model.DTO.DomicilioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "pacientes")
@Getter
@Setter
public class Paciente {
//Atributos
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fechaIngreso;

    //Vinculacion tabla turnos
    @OneToMany(mappedBy = "paciente")
    @JsonIgnore
    private Set<Turno> turnos;

    //Vinculacion tabla domicilio
    @OneToOne
    @JoinColumn(name = "id_domicilio" , referencedColumnName = "id")
    private Domicilio domicilio;

}
