package com.iesam.bibliotecaDigital2.libro.domain;

public class GetLibroUseCase {

    private LibroRepository libroRepository;

    public GetLibroUseCase(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public Libro execute (String id){

     return   libroRepository.showLibro(id);
    }
}
