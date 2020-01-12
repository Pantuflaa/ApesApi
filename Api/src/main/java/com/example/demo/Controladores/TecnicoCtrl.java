package com.example.demo.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.Entidades.Tecnico;
import com.example.demo.Servicios.TecnicoServ;

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
@RequestMapping("/v1/tecnico")
public class TecnicoCtrl{
    @Autowired
    @Qualifier("serviciotecnico")
    TecnicoServ servicio;

    @GetMapping("/obtener")
    public Tecnico obtenerTecnico(@RequestParam(name="id", required=true) long id){
        return servicio.obtenerporId(id);
    }

    @PostMapping("/agregar")
    public boolean agregarTecnico(@RequestBody @Valid Tecnico tecnico){
        return servicio.crear(tecnico);
    }

    @PutMapping("/actualizar")
    public boolean actualizarTecnico(@RequestBody @Valid Tecnico tecnico){
        return servicio.actualizar(tecnico);
    }

    @DeleteMapping("/borrar/{id}")
    public boolean borrarTecnico(@PathVariable("id") long id){
        return servicio.borrar(id);
    }

    @GetMapping("/obtenerTodo")
    public List<Tecnico> getAllTecnico(){
        return servicio.obtenerAll();
    }

}