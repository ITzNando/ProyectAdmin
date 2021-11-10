package com.example.proyect.Servicio;

import com.example.proyect.Modelo.Usuario;

public interface IUsuarioS {

    public Usuario findByUsername(String username);
    public Usuario registrar(Usuario u);
}
