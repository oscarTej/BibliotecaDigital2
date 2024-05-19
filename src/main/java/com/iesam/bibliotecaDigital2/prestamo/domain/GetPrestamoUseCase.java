package com.iesam.bibliotecaDigital2.prestamo.domain;

public class GetPrestamoUseCase {

    private PrestamoRespository prestamoRespository;

    public GetPrestamoUseCase(PrestamoRespository prestamoRespository) {
        this.prestamoRespository = prestamoRespository;
    }

    public Prestamo execute (Prestamo id){
        prestamoRespository.getPrestamoId(id)
    }
}
