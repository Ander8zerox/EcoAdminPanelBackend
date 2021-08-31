package com.ecorecoleccion.ecorecoleccion.dao;

import com.ecorecoleccion.ecorecoleccion.dao.model.Recoleccion;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * Interface que define el contrato para las operaciones CRUD
 * @author yoiner.cabezas
 */
public interface RecoleccionRepository extends Repository<Recoleccion, Integer> {

    /**
     * Metodo que permite obtener todas las recolecciones
     * @return listado de recolecciones
     */
    List<Recoleccion> findAll();

    /**
     * Metodo que permite obtener una recoleccion especifica
     * @param id identificador de la recoleccion
     * @return recoleccion
     */
    Recoleccion findById(int id);

    /**
     * Metodo que permite guardar una recoleccion
     * @param recoleccion data a guardar
     * @return
     */
    Recoleccion save(Recoleccion recoleccion);

    /**
     * Metodo que permite eliminar una recoleccion
     * @param recoleccion recoleccion a eliminar
     */
    void delete(Recoleccion recoleccion);

}
