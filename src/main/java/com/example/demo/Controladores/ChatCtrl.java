package com.example.demo.controladores;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.entidades.Chat;
import com.example.demo.servicios.Chatserv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/chat")
public class Chatctrl{
    @Autowired
    @Qualifier("serviciochat")
        Chatserv servicio;

    @GetMapping("/obtener")
    public Chat obtenerChat(@RequestParam(name="id", required=true) long id){
        return servicio.obtenerporId(id);
    }

    @PostMapping("/agregar")
    public boolean agregarChat(@RequestBody @Valid Chat chat){
        return servicio.crear(chat);
    }

    @PutMapping("/actualizar")
    public boolean actualizarChat(@RequestBody @Valid Chat chat){
        return servicio.actualizar(chat);
    }

    @DeleteMapping("/borrar/{id}")
    public boolean borrarChat(@PathVariable("id") long id){
        return servicio.borrar(id);
    }

    @GetMapping("/obtenerTodo")
    public List<Chat> getAllChat(){
        return servicio.obtenerAll();
    }

    @GetMapping("/obtenerPorTCS")
    public List<Chat> getAllTCS(@RequestParam(name="id_tecnico",required=true) long idTecnico,@RequestParam(name="id_consulta",required=true) long idConsulta,@RequestParam(name="state",required=true) long state){
        return servicio.obtenerporTecnicoConsultasState(idTecnico, idConsulta, state);
    }
    @GetMapping("/obtenerPorUCS")
    public List<Chat> getAllUCS(@RequestParam(name="id_usuario",required=true) long idUsuario,@RequestParam(name="id_consulta",required=true) long idConsulta,@RequestParam(name="state",required=true) long state){
        return servicio.obtenerporUsuarioConsultasState(idUsuario, idConsulta, state);
    }
    @GetMapping("/obtenerPorConsulta")
    public Chat obtenerPorConsulta(@RequestParam(name="id", required=true) long id){
        return servicio.obtenerporConsulta(id);
    }



}