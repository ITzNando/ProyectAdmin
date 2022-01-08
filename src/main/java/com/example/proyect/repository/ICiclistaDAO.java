package com.example.proyect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.proyect.modelo.Ciclista;

@Repository
public interface ICiclistaDAO extends JpaRepository<Ciclista, Integer>{

}
