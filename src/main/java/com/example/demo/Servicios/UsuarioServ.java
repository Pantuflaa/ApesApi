package com.example.demo.servicios;

import java.util.List;

import com.example.demo.entidades.Usuario;
import com.example.demo.repositorios.Usuariorep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("serviciousuario")
public class Usuarioserv{
    @Autowired
    @Qualifier("repositoriousuario")
    private Usuariorep repositorio;

    public boolean crear(Usuario usuario){
        try{
            repositorio.save(usuario);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean actualizar(Usuario usuario){
        try{
            repositorio.save(usuario);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean borrar(long id){
        try{
            Usuario usuario = repositorio.findById(id);
            repositorio.delete(usuario);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Usuario obtenerporId(long id){
        return repositorio.findById(id);
    }

    public List<Usuario> obtenerAll(){
        return repositorio.findAll();
    }

}