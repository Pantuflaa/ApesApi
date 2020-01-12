package com.example.demo.Servicios;

import java.util.List;

import com.example.demo.Entidades.Feedback;
import com.example.demo.Repositorios.FeedbackRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("serviciofeedback")
public class FeedbackServ{
    @Autowired
    @Qualifier("repositoriofeedback")
    private FeedbackRep repositorio;

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
        return repositorio.findByIdUsuarioAndIdTecnico(idUsuario,idTecnico);
    }
    public List<Feedback> obtenerporU(long idUsuario){
        return repositorio.findByIdUsuario(idUsuario);
    }
    public List<Feedback> obtenerporT(long idTecnico){
        return repositorio.findByIdTecnico(idTecnico);
    }


}