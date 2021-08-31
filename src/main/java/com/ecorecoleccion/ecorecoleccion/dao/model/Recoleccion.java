package com.ecorecoleccion.ecorecoleccion.dao.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yoiner.cabezas
 */

@Getter
@Setter
@Entity
@Table(name = "recoleccion")
public class Recoleccion {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column
    private String barrio;
    @Column
    private String comuna;
    @Column
    private String direccion;
    @Column
    private String cliente;

}
