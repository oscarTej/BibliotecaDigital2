package com.iesam.bibliotecaDigital2.usuario.domain;

public class Usuario {

    public String dni;
    public String nombre;

    public String numeroTelefono;

    public Usuario(String dni, String nombre, String numeroTelefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.numeroTelefono = numeroTelefono;
    }



    public String getNumeroTelefono() {
        return numeroTelefono;
    }

    public void setNumeroTelefono(String numeroTelefono) {
        this.numeroTelefono = numeroTelefono;
    }

    public String getId() {
        return dni;
    }

    public void setId(String id) {
        this.dni = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

