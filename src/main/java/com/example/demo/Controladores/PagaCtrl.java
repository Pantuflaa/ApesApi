package com.example.demo.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.Entidades.Paga;
import com.example.demo.Servicios.PagaServ;

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
public class PagaCtrl{
    @Autowired
    @Qualifier("serviciopaga")
        PagaServ servicio;

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
    public List<Paga> getAllUT(@RequestParam(name="id_tecnico",required=true) long id_tecnico,@RequestParam(name="id_usuario",required=true) long id_usuario){
        return servicio.obtenerporUT(id_tecnico, id_usuario);
    }
    @GetMapping("/obtenerPorU")
    public List<Paga> getAllU(@RequestParam(name="id_usuario",required=true) long id_usuario){
        return servicio.obtenerporU(id_usuario);
    }
    @GetMapping("/obtenerPorT")
    public List<Paga> getAllT(@RequestParam(name="id_tecnico",required=true) long id_tecnico){
        return servicio.obtenerporT(id_tecnico);
    }
}