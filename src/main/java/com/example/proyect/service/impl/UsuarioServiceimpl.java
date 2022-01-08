package com.example.proyect.service.impl;

import com.example.proyect.modelo.Usuario;
import com.example.proyect.repository.IUsuarioDAO;
import com.example.proyect.service.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceimpl implements UsuarioService{

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
