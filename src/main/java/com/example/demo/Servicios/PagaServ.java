package com.example.demo.Servicios;

import java.util.List;

import com.example.demo.Entidades.Paga;
import com.example.demo.Repositorios.PagaRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("serviciopaga")
public class PagaServ{
    @Autowired
    @Qualifier("repositoriopaga")
    private PagaRep repositorio;

    public boolean crear(Paga paga){
        try{
            repositorio.save(paga);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean actualizar(Paga paga){
        try{
            repositorio.save(paga);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean borrar(long id){
        try{
            Paga paga = repositorio.findById(id);
            repositorio.delete(paga);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Paga obtenerporId(long id){
        return repositorio.findById(id);
    }

    public List<Paga> obtenerAll(){
        return repositorio.findAll();
    }
    public List<Paga> obtenerporUT(long idUsuario,long idTecnico){
        return repositorio.findByIdUsuarioAndIdTecnico(idUsuario,idTecnico);
    }
    public List<Paga> obtenerporU(long idUsuario){
        return repositorio.findByIdUsuario(idUsuario);
    }
    public List<Paga> obtenerporT(long idTecnico){
        return repositorio.findByIdTecnico(idTecnico);
    }


}