package com.example.demo.Repositorios;
import java.io.Serializable;
import java.util.List;

import com.example.demo.Entidades.Mensaje;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("repomensaje")
public interface  MensajeRep extends JpaRepository<Mensaje, Serializable>{

    public abstract Mensaje findById(long id);
    public abstract List<Mensaje> findAll();
    public abstract List<Mensaje> findByIdGreaterThanAndIdChat(long id, long idChat);

}