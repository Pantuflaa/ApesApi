package com.example.demo.entidades;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
    String nombret;
    @Column(name="correo")
    String correot;
    @Column(name="pass")
    String passt;

    public Tecnico(){

    }
    public Tecnico(long id,String correot, String nombre,String pass){
        this.id=id;
        this.nombret=nombre;
        this.correot=correot;
        this.passt=pass;
    }
    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correot = correo;
    }
    /**
     * @return the correo
     */
    public String getCorreo() {
        return correot;
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
        this.nombret = nombre;
    }/**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.passt = pass;
    }/**
     * @return the id
     */
    public long getId() {
        return id;
    }/**
     * @return the nombre
     */
    public String getNombre() {
        return nombret;
    }/**
     * @return the pass
     */
    public String getPass() {
        return passt;
    }
}