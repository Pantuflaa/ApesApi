package com.example.demo.repositorios;
import java.io.Serializable;
import java.util.List;

import com.example.demo.entidades.Mensaje;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("repomensaje")
public interface  Mensajerep extends JpaRepository<Mensaje, Serializable>{

    public abstract Mensaje findById(long id);
    public abstract List<Mensaje> findAll();
    public abstract List<Mensaje> findByIdChat(long idChat);
    public abstract List<Mensaje> findByIdGreaterThanAndIdChat(long id, long idChat);

}