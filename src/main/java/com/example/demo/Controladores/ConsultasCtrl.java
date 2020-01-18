package com.example.demo.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.Entidades.Consultas;
import com.example.demo.Servicios.ConsultasServ;

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
@RequestMapping("/v1/consulta")
public class ConsultasCtrl{
    @Autowired
    @Qualifier("servicioconsulta")
        ConsultasServ servicio;

    @GetMapping("/obtener")
    public Consultas obtenerConsulta(@RequestParam(name="id", required=true) long id){
        return servicio.obtenerporId(id);
    }

    @PostMapping("/agregar")
    public boolean agregarConsulta(@RequestBody @Valid Consultas consulta){
        return servicio.crear(consulta);
    }

    @PutMapping("/actualizar")
    public boolean actualizarConsulta(@RequestBody @Valid Consultas consulta){
        return servicio.actualizar(consulta);
    }

    @DeleteMapping("/borrar/{id}")
    public boolean borrarConsulta(@PathVariable("id") long id){
        return servicio.borrar(id);
    }

    @GetMapping("/obtenerTodo")
    public List<Consultas> getAllConsulta(){
        return servicio.obtenerAll();
    }

    @GetMapping("/obtenerPorEstado")
    public List<Consultas> getAllEstado(@RequestParam(name="estado",required=true) String estado){
        return servicio.obtenerporEstado(estado);
    }

}