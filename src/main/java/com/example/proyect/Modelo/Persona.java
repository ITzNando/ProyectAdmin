package com.example.proyect.Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="persona")
public class Persona{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
     
    private String nombre;
    private String correo;
    private String numero;
    
    

    public Persona(Integer id, String nombre, String correo, String numero) {
        this.id = id;
        this.nombre = nombre;
        this.correo = correo;
        this.numero = numero;
    }

    
    public Persona() {
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    @Override
    public String toString() {
        return "Persona [correo=" + correo + ", id=" + id + ", nombre=" + nombre + ", numero=" + numero + "]";
    }

}