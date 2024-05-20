package com.iesam.bibliotecaDigital2.prestamo.domain;

import com.iesam.bibliotecaDigital2.libro.domain.Libro;
import com.iesam.bibliotecaDigital2.usuario.domain.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Prestamo {
    public String id;
    public int fechaDevolucion;
    public int fechaPrestamo;
    public String estadoDelPrestamo;

    public Usuario usuario;
    public Libro libro;

    public Prestamo(String id, int fechaDevolucion, int fechaPrestamo, String estadoDelPrestamo, Usuario usuario, Libro libro) {
        this.id = id;
        this.fechaDevolucion =this.fechaPrestamo +30;
        this.fechaPrestamo = fechaPrestamo;
        this.estadoDelPrestamo = estadoDelPrestamo;
        this.usuario = usuario;
        this.libro = libro;
    }

    public boolean Activado(){
       if(fechaPrestamo < fechaDevolucion){
           System.out.println("esta activado");
       } else {
           System.out.println("tiene que devolver el libro");
       }
        return false;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "id='" + id + '\'' +
                ", FechaDevolucion='" + fechaDevolucion + '\'' +
                ", FechaPrestamo='" + fechaPrestamo + '\'' +
                ", EstadoDelPrestamo='" + estadoDelPrestamo + '\'' +
                ", usuario=" + usuario +
                ", libro=" + libro +
                '}';
    }

}
