package com.example.demo.Repositorios;

import java.io.Serializable;
import java.util.List;

import com.example.demo.Entidades.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository("repositoriousuario")
public interface UsuarioRep extends JpaRepository<Usuario, Serializable>{
    
    public abstract Usuario findById(long id);

    public abstract List<Usuario> findAll();

}