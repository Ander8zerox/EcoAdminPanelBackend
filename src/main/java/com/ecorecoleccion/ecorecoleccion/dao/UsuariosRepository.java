package com.ecorecoleccion.ecorecoleccion.dao;

import org.springframework.data.repository.Repository;

import com.ecorecoleccion.ecorecoleccion.dao.model.Usuario;

public interface UsuariosRepository extends Repository<Usuario, Integer>{
	
	/**
     * Metodo que permite obtener una recoleccion especifica
     * @param id identificador de la recoleccion
     * @return recoleccion
     */
    Usuario findByUsuario(String usuario);
}
