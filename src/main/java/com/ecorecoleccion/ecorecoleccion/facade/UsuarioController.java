package com.ecorecoleccion.ecorecoleccion.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecorecoleccion.ecorecoleccion.business.UsuarioService;
import com.ecorecoleccion.ecorecoleccion.dao.model.Usuario;

/**
 * Clase que expone los endpoints a consumir para las operaciones con usuarios
 * @author yoiner.cabezas
 */

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping({"/usuarios"})
public class UsuarioController {
	
	@Autowired
	UsuarioService service;
	 
	@GetMapping(path = {"/{usuario}/{password}"})
    public Usuario login(@PathVariable("usuario") String usuario,@PathVariable("password") String password){
    	System.out.println("logueando");
    	/*Usuario user = service.consultarUsuario(usuario,password);
    	if(user.getPassword().equals(password)) {
    		System.out.println("autenticación correcta");
    	}*/
		return service.consultarUsuario(usuario,password);
    	
    }

}
