package com.example.demo.repositorios;

import java.io.Serializable;
import java.util.List;

import com.example.demo.entidades.Consultas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("repositorioconsultas")
public interface Consultasrep extends JpaRepository<Consultas, Serializable>{
    
    public abstract Consultas findById(long id);

    public abstract List<Consultas> findByEstado(String estado);

    public abstract List<Consultas> findAll();

}