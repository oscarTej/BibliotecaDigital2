package com.iesam.bibliotecaDigital2.prestamo.domain;

public class ActivePrestamoUseCase {

   private final PrestamoRespository prestamoRespository;


    public ActivePrestamoUseCase(PrestamoRespository prestamoRespository) {
        this.prestamoRespository = prestamoRespository;
    }

    public boolean execute(String id) {

        Prestamo prestamo = prestamoRespository.getPrestamoId(id);
        return prestamo.estadoDelPrestamo;
    }
}
