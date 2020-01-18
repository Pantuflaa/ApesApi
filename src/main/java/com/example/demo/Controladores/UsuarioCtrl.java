package com.example.demo.Controladores;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.Entidades.Usuario;
import com.example.demo.Servicios.UsuarioServ;

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
@RequestMapping("/v1/usuario")
public class UsuarioCtrl{
    @Autowired
    @Qualifier("serviciousuario")
    UsuarioServ servicio;

    @GetMapping("/obtener")
    public Usuario obtenerUsuario(@RequestParam(name="id", required=true) long id){
        return servicio.obtenerporId(id);
    }

    @PostMapping("/agregar")
    public boolean agregarUsuario(@RequestBody @Valid Usuario usuario){
        return servicio.crear(usuario);
    }

    @PutMapping("/actualizar")
    public boolean actualizarUsuario(@RequestBody @Valid Usuario usuario){
        return servicio.actualizar(usuario);
    }

    @DeleteMapping("/borrar/{id}")
    public boolean borrarUsuario(@PathVariable("id") long id){
        return servicio.borrar(id);
    }

    @GetMapping("/obtenerTodo")
    public List<Usuario> getAllUsuario(){
        return servicio.obtenerAll();
    }

}