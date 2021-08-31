package com.ecorecoleccion.ecorecoleccion.dao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author yoiner.cabezas
 */

@Getter
@Setter
@Entity
@Table(name = "security")
public class Usuario {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    @Column
    private String usuario;
    @Column
    private String rol;
    @Column
    private String estado;
    @Column
    private String password;

}
