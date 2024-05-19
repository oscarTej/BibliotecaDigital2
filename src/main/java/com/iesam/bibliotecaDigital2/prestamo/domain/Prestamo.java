package com.iesam.bibliotecaDigital2.prestamo.domain;

import com.iesam.bibliotecaDigital2.libro.domain.Libro;
import com.iesam.bibliotecaDigital2.usuario.domain.Usuario;

public class Prestamo {
    public String id;
    public String FechaDevolucion;
    public String FechaPrestamo;
    public String EstadoDelPrestamo;

    public Usuario usuario;
    public Libro libro;

    public Prestamo(String id, String fechaDevolucion, String fechaPrestamo, String estadoDelPrestamo, Usuario usuario, Libro libro) {

        this.id = id;
        FechaDevolucion = fechaDevolucion;
        FechaPrestamo = fechaPrestamo;
        EstadoDelPrestamo = estadoDelPrestamo;
        this.usuario = usuario;
        this.libro = libro;

        public Prestamo ActualizarPrestamo
    }
}
