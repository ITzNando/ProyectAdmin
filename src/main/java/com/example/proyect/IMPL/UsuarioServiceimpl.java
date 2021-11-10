package com.example.proyect.IMPL;

import com.example.proyect.Interfaz.IUsuarioDAO;
import com.example.proyect.Modelo.Usuario;
import com.example.proyect.Servicio.IUsuarioS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceimpl implements IUsuarioS{

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private IUsuarioDAO usuarioDAO;

    @Override
    public Usuario findByUsername(String username) {
        return usuarioDAO.findByUsername(username);
    }

    @Override
    public Usuario registrar(Usuario u) {
        u.setPassword(passwordEncoder.encode(u.getPassword()));
        return usuarioDAO.save(u);
    }
    
}
