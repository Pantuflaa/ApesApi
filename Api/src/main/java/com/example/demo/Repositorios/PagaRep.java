package com.example.demo.Repositorios;

import java.io.Serializable;
import java.util.List;

import com.example.demo.Entidades.Paga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("repositoriopaga")
public interface PagaRep extends JpaRepository<Paga, Serializable>{
    
    public abstract Paga findById(long id);
    public abstract List<Paga> findAll();
    public abstract List<Paga> findByIdUsuario(long idUsuario);
    public abstract List<Paga> findByIdTecnico(long idTecnico);
    public abstract List<Paga> findByIdUsuarioAndIdTecnico(long idUsuario,long idTecnico);
    
}