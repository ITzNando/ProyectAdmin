package com.example.proyect.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.persistence.Index;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proyect.modelo.Estadistica;
import com.example.proyect.repository.ICiclistaDAO;
import com.example.proyect.repository.IEstadisticaDAO;
import com.example.proyect.service.EstadisticaService;

@Service
public class EstadisticaServiceimpl implements EstadisticaService{


    @Autowired
    private IEstadisticaDAO estadisticaDAO;
    
    @Autowired
    private ICiclistaDAO ciclistaDAO;

	@Override
	public List<Estadistica> findAll() throws Exception {
		return estadisticaDAO.findAll();
	}

	@Override
	public void save(Estadistica estadistica) throws Exception {
		ciclistaDAO.save(estadistica.getCiclista());
		estadisticaDAO.save(estadistica);
		
	}

	@Override
	public void delete(Estadistica estadistica) throws Exception{
		estadisticaDAO.delete(estadistica);
		ciclistaDAO.delete(estadistica.getCiclista());
	} 
	
	@Override
    public Estadistica findByIdEstadistica(Integer idEstadistica) throws Exception {
        return estadisticaDAO.findEstadisticaByIdEstadistica(idEstadistica);
    }

	@Override
	public List<Estadistica> findByTop() throws Exception {
		List<Estadistica> e = estadisticaDAO.findAll();

		Iterator<Estadistica> it = e.iterator();
		int Menor=0;

		while(it.hasNext()){
			Estadistica eTemp = it.next();
			int Tiempo = toMins(eTemp.getTiempo());
			

			if(Menor > Tiempo)
			{
				Menor = Tiempo;
			}
		}
		double prome = 0;
		int diferencia = 0;
		double Mejor = 0;
		int index = 0;

		for(int i = 0; i < e.size(); i++)
		{
			int t = toMins(e.get(i).getTiempo());
			
			if(t == Menor)
			{
				diferencia = 1;
			}
			else
			{
				diferencia = (-1) * (Menor - t);
			}
			prome = (e.get(i).getVelocidad() + e.get(i).getPotencia()) /diferencia;

			if(Mejor < prome)
			{
				Mejor = prome;
				index = i;
			}
			
		}

		List<Estadistica> MejorCiclista = new ArrayList<Estadistica>();
		MejorCiclista.add(e.get(index));
		System.out.println(Arrays.toString(MejorCiclista.toArray()));
		return MejorCiclista;
	}

	private int toMins(String s){
		String[] hourMin = s.split(":");
		int hour = Integer.parseInt(hourMin[0]);
		int mins = Integer.parseInt(hourMin[1]);
		int seconds = Integer.parseInt(hourMin[2]);
		int hoursInMins = hour * 60;
		int secondsToMin = seconds /60;
		return hoursInMins + mins + secondsToMin;
	}
}
