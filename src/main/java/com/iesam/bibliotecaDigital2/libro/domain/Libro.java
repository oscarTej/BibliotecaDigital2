package com.iesam.bibliotecaDigital2.libro.domain;

public class Libro {

    public String id;
    public String titulo;
    public String genero;
    public String autor;
    public String descripcion;

    public Libro(String id,String titulo, String genero, String autor, String descripcion) {
        this.id = id;
        this.titulo= titulo;
        this.genero = genero;
        this.autor = autor;
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", autor='" + autor + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
