package com.example.demo.repositorios;

import java.io.Serializable;
import java.util.List;

import com.example.demo.entidades.Tecnico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("repositoriotecnico")
public interface Tecnicorep extends JpaRepository<Tecnico, Serializable>{
    
    public abstract Tecnico findById(long id);

    public abstract List<Tecnico> findAll();

}