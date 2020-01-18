package com.example.demo.Entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

@Table(name="USUARIO")
@Entity
public class Usuario{

    @Id
    @GenericGenerator(name="incrementusuario", strategy="increment")
    @GeneratedValue(generator="incrementusuario")
    @Column(name="id_usuario")
    long id;

    @Column(name="nombre")
    String nombre;
    @Column(name="correo")
    String correo;
    @Column(name="pass")
    String pass;
    @OneToMany(mappedBy = "id_usuario")
    private Set<Consultas> consultas;
    public Usuario(){}
    public Usuario(long id, String nombre,String pass){
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
