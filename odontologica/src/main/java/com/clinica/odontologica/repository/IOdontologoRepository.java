package com.clinica.odontologica.repository;

import com.clinica.odontologica.model.Odontologo;
import org.hibernate.cfg.JPAIndexHolder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOdontologoRepository extends JpaRepository<Odontologo,Long> {


}