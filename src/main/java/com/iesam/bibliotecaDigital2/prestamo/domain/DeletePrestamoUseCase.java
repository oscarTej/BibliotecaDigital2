package com.iesam.bibliotecaDigital2.prestamo.domain;

public class DeletePrestamoUseCase {
    private PrestamoRespository prestamoRespository;

    public DeletePrestamoUseCase(PrestamoRespository prestamoRespository) {
        this.prestamoRespository = prestamoRespository;
    }

    public void execute(String id){
        prestamoRespository.deletePrestamo(id);
    }
}
