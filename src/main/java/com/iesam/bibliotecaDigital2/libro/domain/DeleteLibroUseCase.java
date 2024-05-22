package com.iesam.bibliotecaDigital2.libro.domain;

public class DeleteLibroUseCase {

    private  LibroRepository libroRepository;

    public DeleteLibroUseCase(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public void execute (String id){

        libroRepository.deleteLibro (id);
    }
}
