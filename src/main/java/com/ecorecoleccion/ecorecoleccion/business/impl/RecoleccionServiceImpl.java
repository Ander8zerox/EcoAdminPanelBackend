package com.ecorecoleccion.ecorecoleccion.business.impl;

import com.ecorecoleccion.ecorecoleccion.business.RecoleccionService;
import com.ecorecoleccion.ecorecoleccion.dao.RecoleccionRepository;
import com.ecorecoleccion.ecorecoleccion.dao.model.Recoleccion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Clase que implementa la interfaz RecoleccionService
 * @author yoiner.cabezas
 */
@Service
public class RecoleccionServiceImpl implements RecoleccionService {

    @Autowired
    private RecoleccionRepository repository;

    @Override
    public List<Recoleccion> listar() {
        return repository.findAll();
    }

    @Override
    public Recoleccion listarId(int id) {
        return repository.findById(id);
    }

    @Override
    public Recoleccion agregar(Recoleccion recoleccion) {
        return repository.save(recoleccion);
    }

    @Override
    public Recoleccion editar(Recoleccion recoleccion) {
        return repository.save(recoleccion);
    }

    @Override
    public Recoleccion eliminar(int id) {
    	Recoleccion recoleccion = repository.findById(id);
    	if(null != recoleccion) {

        	repository.delete(recoleccion);
    	}
    	return recoleccion;
    }
}
