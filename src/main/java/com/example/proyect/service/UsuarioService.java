package com.example.proyect.service;

import com.example.proyect.modelo.Usuario;

public interface UsuarioService {

    public Usuario findByUsername(String username);
    public Usuario registrar(Usuario u);
}
