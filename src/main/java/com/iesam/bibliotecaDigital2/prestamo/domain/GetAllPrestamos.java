package com.iesam.bibliotecaDigital2.prestamo.domain;

import java.util.List;

public class GetAllPrestamos {

    private  final PrestamoRespository prestamoRespository;

    public GetAllPrestamos(PrestamoRespository prestamoRespository) {
        this.prestamoRespository = prestamoRespository;
    }
    public List<Prestamo> execute (){
        return prestamoRespository.allPrestamos();
    }
}
