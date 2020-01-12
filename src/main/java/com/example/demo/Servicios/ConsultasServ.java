package com.example.demo.Servicios;

import java.util.List;

import com.example.demo.Entidades.Consultas;
import com.example.demo.Repositorios.ConsultasRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("servicioconsulta")
public class ConsultasServ{
    @Autowired
    @Qualifier("repositorioconsultas")
    private ConsultasRep repositorio;

    public boolean crear(Consultas consulta){
        try{
            repositorio.save(consulta);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean actualizar(Consultas consulta){
        try{
            repositorio.save(consulta);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean borrar(long id){
        try{
            Consultas consulta = repositorio.findById(id);
            repositorio.delete(consulta);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Consultas obtenerporId(long id){
        return repositorio.findById(id);
    }

    public List<Consultas> obtenerAll(){
        return repositorio.findAll();
    }
    public List<Consultas> obtenerporEstado(String estado){
        return repositorio.findByEstado(estado);
    }

}