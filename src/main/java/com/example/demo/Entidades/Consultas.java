package com.example.demo.Entidades;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import org.hibernate.annotations.GenericGenerator;


@Table(name="CONSULTA")
@Entity
public class Consultas {
    @Id
    @GenericGenerator(name="incrementconsulta", strategy="increment")
    @GeneratedValue(generator="incrementconsulta")
    @Column(name="id_consulta")
    long id;

    @Column(name="titulo")
    String titulo;
    @Column(name="fecha")
    String fecha;
    @Column(name="categoria")
    String categoria;
    @Column(name="estado")
    String estado;
    @Column(name="descripcion")
    String descripcion;
    @Column(name="id_usuario")
    long id_usuario;
    /**
     * @return the descripcion
     */
    public Consultas(){

    }
    public Consultas(long id, String titulo, String descripcion, long id_usuario){
        this.id=id;
        this.titulo=titulo;
        this.descripcion=descripcion;
        this.id_usuario=id_usuario;

    }
    /**
     * @return the categoria
     */
    public String getCategoria() {
        return categoria;
    }
    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }
    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    /**
     * @return the id_usuario
     */
    public long getId_usuario() {
        return id_usuario;
    }/**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }
    /**
     * @param descripcion the descripcion to set
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
    /**
     * @param id_usuario the id_usuario to set
     */
    public void setId_usuario(long id_usuario) {
        this.id_usuario = id_usuario;
    }
    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    /**
     * @param categoria the categoria to set
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }/**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }/**
     * @param fecha the fecha to set
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}