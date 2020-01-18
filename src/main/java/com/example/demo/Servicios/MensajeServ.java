package com.example.demo.servicios;
import java.util.List;

import com.example.demo.entidades.Mensaje;
import com.example.demo.repositorios.Mensajerep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("serviciomensaje")
public class Mensajeserv{
    @Autowired
    @Qualifier("repomensaje")
    Mensajerep repositorio;

    public boolean crear(Mensaje mensaje){
        try{
            repositorio.save(mensaje);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public boolean actualizar(Mensaje mensaje){
        try{
            repositorio.save(mensaje);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    public boolean borrar(long id){
        try{
            Mensaje mensaje = repositorio.findById(id);
            repositorio.delete(mensaje);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public List<Mensaje> obtenerMayorId(long id, long idChat){
        return repositorio.findByIdGreaterThanAndIdChat(id, idChat);
    }
    public List<Mensaje> obtenerTodo(){
        return repositorio.findAll();
    }
    public List<Mensaje>obtenerChat(long idChat){
        return repositorio.findByIdChat(idChat);
    }
}