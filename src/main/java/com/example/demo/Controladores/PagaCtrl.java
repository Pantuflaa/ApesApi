package com.example.demo.controladores;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.entidades.Paga;
import com.example.demo.servicios.Pagaserv;

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
@RequestMapping("/v1/paga")
public class Pagactrl{
    @Autowired
    @Qualifier("serviciopaga")
        Pagaserv servicio;

    @GetMapping("/obtener")
    public Paga obtenerPaga(@RequestParam(name="id", required=true) long id){
        return servicio.obtenerporId(id);
    }

    @PostMapping("/agregar")
    public boolean agregarPaga(@RequestBody @Valid Paga chat){
        return servicio.crear(chat);
    }

    @PutMapping("/actualizar")
    public boolean actualizarPaga(@RequestBody @Valid Paga chat){
        return servicio.actualizar(chat);
    }

    @DeleteMapping("/borrar/{id}")
    public boolean borrarPaga(@PathVariable("id") long id){
        return servicio.borrar(id);
    }

    @GetMapping("/obtenerTodo")
    public List<Paga> getAllPaga(){
        return servicio.obtenerAll();
    }

    @GetMapping("/obtenerPorUT")
    public List<Paga> getAllUT(@RequestParam(name="id_tecnico",required=true) long idTecnico,@RequestParam(name="id_usuario",required=true) long idUsuario){
        return servicio.obtenerporUT(idTecnico, idUsuario);
    }
    @GetMapping("/obtenerPorU")
    public List<Paga> getAllU(@RequestParam(name="id_usuario",required=true) long idUsuario){
        return servicio.obtenerporU(idUsuario);
    }
    @GetMapping("/obtenerPorT")
    public List<Paga> getAllT(@RequestParam(name="id_tecnico",required=true) long idTecnico){
        return servicio.obtenerporT(idTecnico);
    }
}