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
    public String estadoDelPrestamo;

    public Usuario usuario;
    public Libro libro;

    public Prestamo(String id, Date fechaDevolucion, Date fechaPrestamo, String estadoDelPrestamo, Usuario usuario, Libro libro) {
        this.id = id;
        this.fechaDevolucion =calcularFechaDeDevolucion(fechaPrestamo);
        this.fechaPrestamo = fechaPrestamo;
        this.estadoDelPrestamo = estadoDelPrestamo;
        this.usuario = usuario;
        this.libro = libro;
    }
    private Date calcularFechaDeDevolucion(Date fechaPrestamo){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaPrestamo);
        calendar.add(Calendar.DAY_OF_YEAR,30);
        return calendar.getTime();
    }

    public boolean Activado(){
    Date fechaActual= new Date();
    return fechaActual.after(fechaActual) && fechaActual.before(fechaDevolucion);
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }



    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = calcularFechaDeDevolucion(fechaPrestamo);
    }

    public String getEstadoDelPrestamo() {
        return estadoDelPrestamo;
    }

    public void setEstadoDelPrestamo(String estadoDelPrestamo) {
        this.estadoDelPrestamo = estadoDelPrestamo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
}
