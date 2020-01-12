package com.example.demo.Servicios;

import java.util.List;

import com.example.demo.Entidades.Usuario;
import com.example.demo.Repositorios.UsuarioRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("serviciousuario")
public class UsuarioServ{
    @Autowired
    @Qualifier("repositoriousuario")
    private UsuarioRep repositorio;

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