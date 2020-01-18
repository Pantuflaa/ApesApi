package com.example.demo.servicios;

import java.util.List;

import com.example.demo.entidades.Paga;
import com.example.demo.repositorios.Pagarep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("serviciopaga")
public class Pagaserv{
    @Autowired
    @Qualifier("repositoriopaga")
    private Pagarep repositorio;

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
        return repositorio.findByIdUsuariopAndIdTecnicop(idUsuario,idTecnico);
    }
    public List<Paga> obtenerporU(long idUsuario){
        return repositorio.findByIdUsuariop(idUsuario);
    }
    public List<Paga> obtenerporT(long idTecnico){
        return repositorio.findByIdTecnicop(idTecnico);
    }


}