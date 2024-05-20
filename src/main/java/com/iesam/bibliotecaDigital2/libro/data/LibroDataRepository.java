package com.iesam.bibliotecaDigital2.libro.data;

import com.iesam.bibliotecaDigital2.libro.data.Local.LibroFileLocalDataSource;
import com.iesam.bibliotecaDigital2.libro.domain.Libro;
import com.iesam.bibliotecaDigital2.libro.domain.LibroRepository;

import java.util.List;

public class LibroDataRepository implements LibroRepository {

     private LibroFileLocalDataSource libroFileLocalDataSource;

    public LibroDataRepository(LibroFileLocalDataSource libroFileLocalDataSource) {
        this.libroFileLocalDataSource = libroFileLocalDataSource;
    }

    @Override
    public void deleteLibro(String id) {

        libroFileLocalDataSource.delete(id);

    }

    @Override
    public Libro showLibro(String id) {
        return libroFileLocalDataSource.findById(id);
    }

    @Override
    public void saveLibro(Libro libro) {

        libroFileLocalDataSource.save(libro);

    }

    @Override
    public List<Libro> showAllLibros() {
        return libroFileLocalDataSource.findAll();
    }
}
