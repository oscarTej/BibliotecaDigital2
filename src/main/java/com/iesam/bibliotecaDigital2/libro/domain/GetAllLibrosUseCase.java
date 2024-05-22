package com.iesam.bibliotecaDigital2.libro.domain;

import java.util.List;

public class GetAllLibrosUseCase {

    private LibroRepository libroRepository;

    public GetAllLibrosUseCase(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public List<Libro> execute (){
       return libroRepository.showAllLibros();
    }
}
