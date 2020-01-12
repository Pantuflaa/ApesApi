package com.example.demo.Repositorios;

import java.io.Serializable;
import java.util.List;

import com.example.demo.Entidades.Feedback;;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("repositoriofeedback")
public interface FeedbackRep extends JpaRepository<Feedback, Serializable>{
    
    public abstract Feedback findById(long id);
    public abstract List<Feedback> findAll();
    public abstract List<Feedback> findByIdUsuario(long idUsuario);
    public abstract List<Feedback> findByIdTecnico(long idTecnico);
    public abstract List<Feedback> findByIdUsuarioAndIdTecnico(long idUsuario,long idTecnico);
    
}