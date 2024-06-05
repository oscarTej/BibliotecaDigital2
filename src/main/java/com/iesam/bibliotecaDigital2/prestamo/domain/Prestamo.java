package com.iesam.bibliotecaDigital2.prestamo.domain;

import com.iesam.bibliotecaDigital2.libro.domain.Libro;
import com.iesam.bibliotecaDigital2.usuario.domain.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;


public class Prestamo {
    public String id;
    public Date fechaDevolucion;
    public Date fechaPrestamo;
    public boolean estadoDelPrestamo;

    public Usuario usuario;
    public Libro libro;

    //constructor para crear el prestamo
    public Prestamo(String id, Usuario usuario, Libro libro) {
        this.id = id;
        this.fechaPrestamo =new Date();
        this.fechaDevolucion = calcularFechaDevolucion(this.fechaPrestamo);
        this.estadoDelPrestamo = calcularEstadoDelPrestamo() ;
        this.usuario = usuario;
        this.libro = libro;
    }
// constructor prestamo ya creado por id
   public Prestamo(String id, Date fechaDevolucion, Date fechaPrestamo,  Usuario usuario, Libro libro) {
        this.id = id;
        this.fechaDevolucion = fechaDevolucion;
        this.fechaPrestamo = fechaPrestamo;
        this.estadoDelPrestamo =calcularEstadoDelPrestamo() ;
        this.usuario = usuario;
        this.libro = libro;
    }




    @Override
    public String toString() {
        return "Prestamo{" +
                "id='" + id + '\'' +
                ", fechaDevolucion='" + fechaDevolucion + '\'' +
                ", fechaPrestamo='" + fechaPrestamo + '\'' +
                ", usuario=" + usuario +
                ", libro=" + libro +
                '}';
    }

    private boolean calcularEstadoDelPrestamo() {
        return  (fechaPrestamo.before(fechaDevolucion) );
    }


    private Date calcularFechaDevolucion(Date fechaPrestamo) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaPrestamo);
        calendar.add(Calendar.DAY_OF_YEAR, 27);
        return calendar.getTime();
    }
}





