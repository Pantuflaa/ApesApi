package com.example.demo.repositorios;

import java.io.Serializable;
import java.util.List;

import com.example.demo.entidades.Feedback;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("repositoriofeedback")
public interface Feedbackrep extends JpaRepository<Feedback, Serializable>{
    
    public abstract Feedback findById(long id);
    public abstract List<Feedback> findAll();
    public abstract List<Feedback> findByIdUsuariof(long idUsuario);
    public abstract List<Feedback> findByIdTecnicof(long idTecnico);
    public abstract List<Feedback> findByIdUsuariofAndIdTecnicof(long idUsuario,long idTecnico);
    
}