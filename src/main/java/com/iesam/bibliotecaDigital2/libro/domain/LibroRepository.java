package com.iesam.bibliotecaDigital2.libro.domain;

import java.util.List;

public interface LibroRepository {


    void deleteLibro(String id);

    Libro showLibro(String id);

    void saveLibro(Libro libro);

    List<Libro> showAllLibros();
}
