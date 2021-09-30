package com.clinica.odontologica.service;

import com.clinica.odontologica.model.DTO.DomicilioDTO;
import com.clinica.odontologica.model.DTO.PacienteDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class PacienteServiceTest {

    @Autowired
    IPacienteService iPacienteService;

    @Test
    public void testAgregarPaciente() {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Nora");
        pacienteDTO.setApellido("Roberts");
        pacienteDTO.setDni("1950");
        pacienteDTO.setFechaIngreso(new Date());

        iPacienteService.agregarPaciente(pacienteDTO);

        assertNotNull(pacienteDTO);
        assertTrue(pacienteDTO.getNombre().equals("Nora"));
    }

    @Test
    public void testGetAll()
    {
        PacienteDTO pacienteDTO = new PacienteDTO();
        pacienteDTO.setNombre("Agatha");
        pacienteDTO.setApellido("Christie");
        pacienteDTO.setDni("1890");
        pacienteDTO.setFechaIngreso(new Date());

        iPacienteService.agregarPaciente(pacienteDTO);

        Collection<PacienteDTO> pacientes =
                iPacienteService.getAll();
        boolean resultado = pacientes.size() > 0;

        assertTrue(resultado);
    }
}
