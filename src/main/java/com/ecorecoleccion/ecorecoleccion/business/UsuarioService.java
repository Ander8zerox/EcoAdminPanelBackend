package com.ecorecoleccion.ecorecoleccion.business;

import com.ecorecoleccion.ecorecoleccion.dao.model.Usuario;

/**
 * Interfaz que define el contrato para el CRUD
 * @author yoiner.cabezas
 */
public interface UsuarioService {
	
	Usuario consultarUsuario(String usuario, String password);
}
