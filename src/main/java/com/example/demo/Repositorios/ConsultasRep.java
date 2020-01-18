package com.example.demo.Repositorios;

import java.io.Serializable;
import java.util.List;

import com.example.demo.Entidades.Consultas;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("repositorioconsultas")
public interface ConsultasRep extends JpaRepository<Consultas, Serializable>{
    
    public abstract Consultas findById(long id);

    public abstract List<Consultas> findByEstado(String estado);

    public abstract List<Consultas> findAll();

}