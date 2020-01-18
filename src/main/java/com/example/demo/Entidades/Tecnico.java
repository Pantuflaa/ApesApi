package com.example.demo.Entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Table(name="TECNICO")
@Entity
public class Tecnico{
    
    @Id
    @GenericGenerator(name="incrementtecnico", strategy="increment")
    @GeneratedValue(generator="incrementtecnico")
    @Column(name="id_tecnico")
    long id;
    
    @Column(name="nombre")
    String nombre;
    @Column(name="correo")
    String correo;
    @Column(name="pass")
    String pass;

    public Tecnico(){

    }
    public Tecnico(long id, String nombre,String pass){
        this.id=id;
        this.nombre=nombre;
        this.pass=pass;
    }
    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }/**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }/**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }/**
     * @return the id
     */
    public long getId() {
        return id;
    }/**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }/**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }
}