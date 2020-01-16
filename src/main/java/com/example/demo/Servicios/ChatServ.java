package com.example.demo.Servicios;

import java.util.List;

import com.example.demo.Entidades.Chat;
import com.example.demo.Repositorios.ChatRep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("serviciochat")
public class ChatServ{
    @Autowired
    @Qualifier("repositoriochat")
    private ChatRep repositorio;

    public boolean crear(Chat chat){
        try{
            repositorio.save(chat);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean actualizar(Chat chat){
        try{
            repositorio.save(chat);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public boolean borrar(long id){
        try{
            Chat chat = repositorio.findById(id);
            repositorio.delete(chat);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    public Chat obtenerporId(long id){
        return repositorio.findById(id);
    }

    public List<Chat> obtenerAll(){
        return repositorio.findAll();
    }
    public List<Chat> obtenerporTecnicoConsultasState(long idTecnico,long idConsulta,long state){
        return repositorio.findByIdTecnicoAndIdConsultaAndState(idTecnico, idConsulta, state);
    }
    public List<Chat> obtenerporUsuarioConsultasState(long idUsuario,long idConsulta,long state){
        return repositorio.findByIdUsuarioAndIdConsultaAndState(idUsuario, idConsulta, state);
    }
    public Chat obtenerporConsulta(long idConsulta){
        return repositorio.findByIdConsulta(idConsulta);
    }

}