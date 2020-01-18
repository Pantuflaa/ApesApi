package com.example.demo.controladores;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.entidades.Feedback;
import com.example.demo.servicios.Feedbackserv;

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
@RequestMapping("/v1/feedback")
public class Feedbackctrl{
    @Autowired
    @Qualifier("serviciofeedback")
        Feedbackserv servicio;

    @GetMapping("/obtener")
    public Feedback obtenerFeedback(@RequestParam(name="id", required=true) long id){
        return servicio.obtenerporId(id);
    }

    @PostMapping("/agregar")
    public boolean agregarFeedback(@RequestBody @Valid Feedback chat){
        return servicio.crear(chat);
    }

    @PutMapping("/actualizar")
    public boolean actualizarFeedback(@RequestBody @Valid Feedback chat){
        return servicio.actualizar(chat);
    }

    @DeleteMapping("/borrar/{id}")
    public boolean borrarFeedback(@PathVariable("id") long id){
        return servicio.borrar(id);
    }

    @GetMapping("/obtenerTodo")
    public List<Feedback> getAllFeedback(){
        return servicio.obtenerAll();
    }

    @GetMapping("/obtenerPorUT")
    public List<Feedback> getAllUT(@RequestParam(name="id_tecnico",required=true) long idTecnico,@RequestParam(name="id_usuario",required=true) long idUsuario){
        return servicio.obtenerporUT(idTecnico, idUsuario);
    }
    @GetMapping("/obtenerPorU")
    public List<Feedback> getAllU(@RequestParam(name="id_usuario",required=true) long idUsuario){
        return servicio.obtenerporU(idUsuario);
    }
    @GetMapping("/obtenerPorT")
    public List<Feedback> getAllT(@RequestParam(name="id_tecnico",required=true) long idTecnico){
        return servicio.obtenerporT(idTecnico);
    }
}