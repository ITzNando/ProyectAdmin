package com.example.proyect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.proyect.modelo.Estadistica;

@Repository
public interface IEstadisticaDAO extends JpaRepository<Estadistica, Integer>{
	
	@Query("SELECT e FROM Estadistica e WHERE e.idEstadistica = ?1")
	Estadistica findEstadisticaByIdEstadistica(Integer idEstadistica);
	
	@Query("SELECT e FROM Estadistica e WHERE e.tiempo IN (SELECT MIN(e.tiempo) FROM Estadistica e)")
	List<Estadistica> findEstadisticaByTop(); 
	 
}
