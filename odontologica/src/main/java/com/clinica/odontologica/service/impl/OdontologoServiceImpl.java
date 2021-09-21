package com.clinica.odontologica.service.impl;

import com.clinica.odontologica.model.DTO.OdontologoDTO;
import com.clinica.odontologica.model.Odontologo;
import com.clinica.odontologica.repository.IOdontologoRepository;
import com.clinica.odontologica.service.IOdontologoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.log4j.Logger;

@Service
public class OdontologoServiceImpl implements IOdontologoService {
   //
    final static Logger log = Logger.getLogger(String.valueOf(OdontologoServiceImpl.class));

    //
    @Autowired
    IOdontologoRepository iOdontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    ModelMapper modelMapper;


    //Implementacion metodos interface
    @Override
    public void agregarOdontologo(OdontologoDTO odontologoDTO) {
        log.debug("Registrando un nuevo odontologo: " + odontologoDTO.toString());
        guardarOdontologo(odontologoDTO);
    }

    @Override
    public OdontologoDTO consultarOdontologo(Long id) {
        Optional<Odontologo> encontrar = iOdontologoRepository.findById(id);
        return mapper.convertValue(encontrar, OdontologoDTO.class);
    }

    @Override
    public void modificarOdontologo(OdontologoDTO odontologoDTO) {
        guardarOdontologo(odontologoDTO);
    }

    @Override
    public void borrarOdontologo(Long id) {
        iOdontologoRepository.deleteById(id);
    }

    @Override
    public Collection<OdontologoDTO> getAll() {
        Collection <Odontologo> allOdontologos = iOdontologoRepository.findAll(Sort.by(Sort.Direction.ASC, "apellido"));
        return modelMapper.map(allOdontologos, new TypeToken<List<OdontologoDTO>>() {}.getType());
    }

    //Metodo creado para agregar y modificar odontologo
    private void guardarOdontologo(OdontologoDTO odontologoDTO){
        Odontologo newOdontologo = mapper.convertValue(odontologoDTO, Odontologo.class);
        iOdontologoRepository.save(newOdontologo);
    }
}
