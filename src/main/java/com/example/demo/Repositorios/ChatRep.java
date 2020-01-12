package com.example.demo.Repositorios;

import java.io.Serializable;
import java.util.List;

import com.example.demo.Entidades.Chat;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("repositoriochat")
public interface ChatRep extends JpaRepository<Chat, Serializable>{
    
    public abstract Chat findById(long id);
    public abstract List<Chat> findAll();
    public abstract List<Chat> findByIdUsuarioAndIdConsultaAndState(long id_usuario,long id_consulta,long state);
    public abstract List<Chat> findByIdTecnicoAndIdConsultaAndState(long id_tecnico,long id_consulta,long state);
    
    
}