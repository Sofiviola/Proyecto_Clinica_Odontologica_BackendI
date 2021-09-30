package com.clinica.odontologica.service.impl;

import com.clinica.odontologica.model.Rol;
import com.clinica.odontologica.model.User;
import com.clinica.odontologica.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

//La interface ya esta hecha
@Service
public class UserService implements UserDetailsService {

    @Autowired
    IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
       Optional<User> user =  iUserRepository.getUserPorNombre(nombreUsuario);

       //Declaro coleccion
        Set<GrantedAuthority> autorizaciones = new HashSet<>();

        //Recorrer coleccion de roles para poder agregarlos
        for (Rol rol: user.get().getRoles()) {
            GrantedAuthority autorizacion = new SimpleGrantedAuthority(rol.getNombre());
            autorizaciones.add(autorizacion);
        }

       //User del framework
        org.springframework.security.core.userdetails.User userDetail = new org.springframework.security.core.userdetails.User(user.get().getNombre(),"{noop}"+user.get().getPassword(),true,true,true,true, autorizaciones);
        return userDetail;
    }
}
