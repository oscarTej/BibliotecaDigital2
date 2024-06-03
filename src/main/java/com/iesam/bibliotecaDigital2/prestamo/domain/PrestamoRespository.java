package com.iesam.bibliotecaDigital2.prestamo.domain;

import java.util.List;

public interface PrestamoRespository {
    Prestamo getPrestamoId(String id);

    void savePrestamo(Prestamo prestamo);

    void deletePrestamo(String id);

    List<Prestamo> allPrestamos();




  //  void finalizarPrestamo(Prestamo finalizarPrestamo);
}
