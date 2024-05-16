package com.iesam.bibliotecaDigital2.libro.domain;

public class Libro {

    public String id;

    private String genero;
    private String autor;
    private String descripcion;

    public Libro(String id, String genero, String autor, String descripcion) {
        this.id = id;
        this.genero = genero;
        this.autor = autor;
        this.descripcion = descripcion;
    }


}
