package com.example.demo.controladores;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.entidades.Mensaje;
import com.example.demo.servicios.Mensajeserv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;




@RestController
@RequestMapping("v1/mensaje")
public class Mensajectrl{
    @Autowired
    @Qualifier("serviciomensaje")
    Mensajeserv servicio;



    @GetMapping("/{consulta}/{id}")
    public List<Mensaje> obtenerMayorId(@PathVariable("id") long id, @PathVariable("consulta") long idChat){
        
        return servicio.obtenerMayorId(id, idChat);
    }

    @PostMapping("/subir")
    public boolean agregarMensaje(@RequestBody @Valid Mensaje mensaje){

        return servicio.crear(mensaje);
    }
    
    @GetMapping("/obtenerTodo")
    public List<Mensaje> getAllMensaje(){
        return servicio.obtenerTodo();
    }
    @GetMapping("/obtenerChat")
    public List<Mensaje> getAllChat(@RequestParam(name="id", required=true)long id){
        return servicio.obtenerChat(id);
    }


}