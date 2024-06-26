package com.iesam.bibliotecaDigital2.prestamo.domain;

public class SavePrestamoUseCase {


    private final PrestamoRespository prestamoRespository;

    public SavePrestamoUseCase(PrestamoRespository prestamoRespository) {
        this.prestamoRespository = prestamoRespository;
    }

    public void execute (Prestamo prestamo){

        prestamoRespository.savePrestamo(prestamo);
    }

}
