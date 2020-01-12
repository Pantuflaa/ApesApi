package com.example.demo.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.Entidades.Chat;
import com.example.demo.Servicios.ChatServ;

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
public class ChatCtrl{
    @Autowired
    @Qualifier("serviciochat")
        ChatServ servicio;

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
    public List<Chat> getAllTCS(@RequestParam(name="id_tecnico",required=true) long id_tecnico,@RequestParam(name="id_consulta",required=true) long id_consulta,@RequestParam(name="state",required=true) long state){
        return servicio.obtenerporTecnicoConsultasState(id_tecnico, id_consulta, state);
    }
    @GetMapping("/obtenerPorUCS")
    public List<Chat> getAllUCS(@RequestParam(name="id_usuario",required=true) long id_usuario,@RequestParam(name="id_consulta",required=true) long id_consulta,@RequestParam(name="state",required=true) long state){
        return servicio.obtenerporUsuarioConsultasState(id_usuario, id_consulta, state);
    }


}