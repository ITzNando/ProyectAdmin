package com.example.proyect.Interfaz;

import com.example.proyect.Modelo.Persona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaI extends JpaRepository<Persona, Integer>{
}


