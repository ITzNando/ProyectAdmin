package com.example.proyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proyect.modelo.Usuario;

@Repository
public interface IUsuarioDAO extends JpaRepository<Usuario, Long>{
    public Usuario findByUsername(String username);
}
