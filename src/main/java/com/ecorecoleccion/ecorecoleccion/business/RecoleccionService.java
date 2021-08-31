package com.ecorecoleccion.ecorecoleccion.business;

import com.ecorecoleccion.ecorecoleccion.dao.model.Recoleccion;

import java.util.List;

/**
 * Interfaz que define el contrato para el CRUD
 * @author yoiner.cabezas
 */
public interface RecoleccionService {


    List<Recoleccion> listar();

    Recoleccion listarId(int id);

    Recoleccion agregar(Recoleccion recoleccion);

    Recoleccion editar(Recoleccion recoleccion);

    Recoleccion eliminar(int id);

}
