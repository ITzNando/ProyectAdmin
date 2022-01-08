package com.example.proyect.modelo;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ciclista")
public class Ciclista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCiclista;
	private String nombre;
	
	

	public Ciclista() {
		super();
	}

	public Ciclista(Integer idCiclista, String nombre) {
		super();
		this.idCiclista = idCiclista;
		this.nombre = nombre;
	}

	public Integer getIdCiclista() {
		return idCiclista;
	}

	public void setIdCiclista(Integer idCiclista) {
		this.idCiclista = idCiclista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Ciclista [idCiclista=" + idCiclista + ", nombre=" + nombre + "]";
	}

	

}