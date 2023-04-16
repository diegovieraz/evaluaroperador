package com.diegoviera.evaluaroperador.domain.model;

import java.io.Serializable;

public class EvaluadoModel implements Serializable {

    private int id;
    private String nombre;
    private String apellido;
    private String anexo;
    private int dni;
    private String negocio;
    private String cartera;
    private String fecIngreso;
    private String zonal;

    public EvaluadoModel(int id, String nombre, String apellido, String anexo, int dni, String negocio, String cartera, String fecIngreso, String zonal) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anexo = anexo;
        this.dni = dni;
        this.negocio = negocio;
        this.cartera = cartera;
        this.fecIngreso = fecIngreso;
        this.zonal = zonal;
    }

    public EvaluadoModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getAnexo() {
        return anexo;
    }

    public void setAnexo(String anexo) {
        this.anexo = anexo;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNegocio() {
        return negocio;
    }

    public void setNegocio(String negocio) {
        this.negocio = negocio;
    }

    public String getCartera() {
        return cartera;
    }

    public void setCartera(String cartera) {
        this.cartera = cartera;
    }

    public String getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(String fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public String getZonal() {
        return zonal;
    }

    public void setZonal(String zonal) {
        this.zonal = zonal;
    }
}
