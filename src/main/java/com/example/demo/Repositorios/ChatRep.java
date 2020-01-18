package com.example.demo.repositorios;

import java.io.Serializable;
import java.util.List;

import com.example.demo.entidades.Chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("repositoriochat")
public interface Chatrep extends JpaRepository<Chat, Serializable>{
    
    public abstract Chat findById(long id);
    public abstract List<Chat> findAll();
    public abstract List<Chat> findByIdUsuarioAndIdConsultaAndState(long idUsuario,long idConsulta,long state);
    public abstract List<Chat> findByIdTecnicoAndIdConsultaAndState(long idTecnico,long idConsulta,long state);
    public abstract Chat findByIdConsulta(long idConsulta);
    
    
}