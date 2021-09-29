package com.clinica.odontologica.service;

import com.clinica.odontologica.model.DTO.OdontologoDTO;
import org.junit.jupiter.api.Test;
import com.clinica.odontologica.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collection;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OdontologoServiceTest {

    @Autowired
    IOdontologoService iOdontologoService;

    @Test
    public void testAgregarOdontologo() {
      OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Julio");
        odontologoDTO.setApellido("Cesar");
        odontologoDTO.setMatricula(100);
        iOdontologoService.agregarOdontologo(odontologoDTO);

        assertNotNull(odontologoDTO);
        assertTrue(odontologoDTO.getNombre().equals("Julio"));
    }

    @Test
    public void testGetAll()
    {
        OdontologoDTO odontologoDTO = new OdontologoDTO();
        odontologoDTO.setNombre("Napoleon");
        odontologoDTO.setApellido("Bonaparte");
        odontologoDTO.setMatricula(1769);

        iOdontologoService.agregarOdontologo(odontologoDTO);

        Collection<OdontologoDTO> odontologos =
                iOdontologoService.getAll();
        boolean resultado = odontologos.size() > 0;

        assertTrue(resultado);
    }

}
