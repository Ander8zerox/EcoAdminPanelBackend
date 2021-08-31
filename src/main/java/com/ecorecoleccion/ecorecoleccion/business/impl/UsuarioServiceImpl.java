package com.ecorecoleccion.ecorecoleccion.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecorecoleccion.ecorecoleccion.business.UsuarioService;
import com.ecorecoleccion.ecorecoleccion.dao.UsuariosRepository;
import com.ecorecoleccion.ecorecoleccion.dao.model.Usuario;

/**
 * Clase que implementa la interfaz UsuarioService
 * @author yoiner.cabezas
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuariosRepository repository;
	
	@Override
	public Usuario consultarUsuario(String username, String password) {
		Usuario user = repository.findByUsuario(username);
		System.out.println("ROL OBTENIDO : " + user.getRol());
		return user;
	}

}
