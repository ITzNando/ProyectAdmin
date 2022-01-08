package com.example.proyect.modelo;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "estadistica")
public class Estadistica { 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEstadistica;
	private String tiempo; 
	private Integer velocidad;
	private Integer potencia;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_ciclista")
	private Ciclista ciclista;

	public Estadistica() {
		super();
	}

	public Integer getIdEstadistica() {
		return idEstadistica;
	}

	public void setIdEstadistica(Integer idEstadistica) {
		this.idEstadistica = idEstadistica;
	}

	public String getTiempo() {
		return tiempo;
	}

	public void setTiempo(String tiempo) {
		this.tiempo = tiempo;
	}

	public Integer getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(Integer velocidad) {
		this.velocidad = velocidad;
	}

	public Integer getPotencia() {
		return potencia;
	}

	public void setPotencia(Integer potencia) {
		this.potencia = potencia;
	}

	public Ciclista getCiclista() {
		return ciclista;
	}

	public void setCiclista(Ciclista ciclista) {
		this.ciclista = ciclista;
	}

	@Override
	public int hashCode() {
		return Objects.hash(ciclista, idEstadistica, potencia, tiempo, velocidad);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estadistica other = (Estadistica) obj;
		return Objects.equals(ciclista, other.ciclista) && Objects.equals(idEstadistica, other.idEstadistica)
				&& Objects.equals(potencia, other.potencia) && Objects.equals(tiempo, other.tiempo)
				&& Objects.equals(velocidad, other.velocidad);
	}

	@Override
	public String toString() {
		return "Estadistica [idEstadistica=" + idEstadistica + ", tiempo=" + tiempo + ", velocidad=" + velocidad
				+ ", potencia=" + potencia + ", ciclista=" + ciclista + "]";
	}

}