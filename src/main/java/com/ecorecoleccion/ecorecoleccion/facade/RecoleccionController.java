package com.ecorecoleccion.ecorecoleccion.facade;

import com.ecorecoleccion.ecorecoleccion.business.RecoleccionService;
import com.ecorecoleccion.ecorecoleccion.dao.model.Recoleccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Clase que expone los endpoints a consumir para las operaciones con recolecciones
 * @author yoiner.cabezas
 */

@PreAuthorize("authenticated")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/recolecciones"})
public class RecoleccionController {

    @Autowired
    RecoleccionService service;

    @GetMapping
    public List<Recoleccion> listar(){
    	System.out.println("Consumiendo");
        return service.listar();
    }
    
    @PostMapping
    @PreAuthorize("hasAuthority('administrador') OR hasAuthority('digitador')")
    public Recoleccion agregar(@RequestBody Recoleccion recoleccion) {
		System.out.println(recoleccion.getBarrio());
    	return service.agregar(recoleccion);
    }
    
    
    @GetMapping(path = {"/{id}"})
    @PreAuthorize("hasAuthority('administrador') OR hasAuthority('digitador')")
    public Recoleccion listarId(@PathVariable("id") int id){
    	System.out.println("Listando");
		return service.listarId(id);
    	
    }
    
    @PutMapping(path = {"/{id}"})
    @PreAuthorize("hasAuthority('administrador') OR hasAuthority('digitador')")
    public Recoleccion editar(@RequestBody Recoleccion recoleccion, @PathVariable("id") int id) {
    	recoleccion.setId(id);
    	System.out.println("Editando");
    	return service.editar(recoleccion);
    }
    
    @DeleteMapping(path = {"/{id}"})
    @PreAuthorize("hasAuthority('administrador')")
    public Recoleccion eliminar(@PathVariable("id") int id) {
		return service.eliminar(id);
    	
    }
}
