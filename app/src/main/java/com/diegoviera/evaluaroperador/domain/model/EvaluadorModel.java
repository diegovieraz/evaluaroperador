package com.diegoviera.evaluaroperador.domain.model;

import java.io.Serializable;

public class EvaluadorModel implements Serializable {

    private int id;
    private String usuario;
    private String password;
    private String nombre;
    private String apellido;
    private String cargo;
    private String negocio;

    public EvaluadorModel(int id, String usuario, String password, String nombre, String apellido, String cargo, String negocio) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cargo = cargo;
        this.negocio = negocio;
    }

    public EvaluadorModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getNegocio() {
        return negocio;
    }

    public void setNegocio(String negocio) {
        this.negocio = negocio;
    }
}
