package com.iesam.bibliotecaDigital2.prestamo.domain;

public interface PrestamoRespository {
    void getPrestamoId(Prestamo id);

    void savePrestamo(Prestamo prestamo);
}
