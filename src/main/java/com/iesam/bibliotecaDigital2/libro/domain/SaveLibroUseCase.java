package com.iesam.bibliotecaDigital2.libro.domain;

public class SaveLibroUseCase {

    private LibroRepository libroRepository;

    public SaveLibroUseCase(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public void execute (Libro libro){
        libroRepository.saveLibro(libro);
    }
}
