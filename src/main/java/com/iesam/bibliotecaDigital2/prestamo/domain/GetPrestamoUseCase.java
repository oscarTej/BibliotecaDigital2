package com.iesam.bibliotecaDigital2.prestamo.domain;

public class GetPrestamoUseCase {

    private final PrestamoRespository prestamoRespository;

    public GetPrestamoUseCase(PrestamoRespository prestamoRespository) {
        this.prestamoRespository = prestamoRespository;
    }

    public Prestamo execute (String id){
      return   prestamoRespository.getPrestamoId(id);

    }
}
