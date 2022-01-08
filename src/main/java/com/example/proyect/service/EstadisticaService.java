package com.example.proyect.service;

import java.util.List;

import com.example.proyect.modelo.Estadistica;

public interface EstadisticaService { 
	
	List<Estadistica> findAll() throws Exception;
	void save(Estadistica estadistica) throws Exception; 
	void delete(Estadistica estadistica	) throws Exception;
	Estadistica findByIdEstadistica(Integer idEstadistica) throws Exception;
	List<Estadistica> findByTop() throws Exception;
}
