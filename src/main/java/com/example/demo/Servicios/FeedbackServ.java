package com.example.demo.servicios;

import java.util.List;

import com.example.demo.entidades.Feedback;
import com.example.demo.repositorios.Feedbackrep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("serviciofeedback")
public class Feedbackserv{
    @Autowired
    @Qualifier("repositoriofeedback")
    private Feedbackrep repositorio;

    public boolean crear(Feedback feedback){
        try{
            repositorio.save(feedback);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean actualizar(Feedback feedback){
        try{
            repositorio.save(feedback);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean borrar(long id){
        try{
            Feedback feedback = repositorio.findById(id);
            repositorio.delete(feedback);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Feedback obtenerporId(long id){
        return repositorio.findById(id);
    }

    public List<Feedback> obtenerAll(){
        return repositorio.findAll();
    }
    public List<Feedback> obtenerporUT(long idUsuario,long idTecnico){
        return repositorio.findByIdUsuariofAndIdTecnicof(idUsuario,idTecnico);
    }
    public List<Feedback> obtenerporU(long idUsuario){
        return repositorio.findByIdUsuariof(idUsuario);
    }
    public List<Feedback> obtenerporT(long idTecnico){
        return repositorio.findByIdTecnicof(idTecnico);
    }


}