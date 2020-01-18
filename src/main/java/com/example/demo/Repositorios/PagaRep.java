package com.example.demo.repositorios;

import java.io.Serializable;
import java.util.List;

import com.example.demo.entidades.Paga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("repositoriopaga")
public interface Pagarep extends JpaRepository<Paga, Serializable>{
    
    public abstract Paga findById(long id);
    public abstract List<Paga> findAll();
    public abstract List<Paga> findByIdUsuariop(long idUsuario);
    public abstract List<Paga> findByIdTecnicop(long idTecnico);
    public abstract List<Paga> findByIdUsuariopAndIdTecnicop(long idUsuario,long idTecnico);
    
}