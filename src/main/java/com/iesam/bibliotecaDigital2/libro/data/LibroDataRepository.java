package com.iesam.bibliotecaDigital2.libro.data;

import com.iesam.bibliotecaDigital2.libro.data.Local.FileLocalDataSource;
import com.iesam.bibliotecaDigital2.libro.domain.Libro;
import com.iesam.bibliotecaDigital2.libro.domain.LibroRepository;

import java.util.List;

public class LibroDataRepository implements LibroRepository {

     private FileLocalDataSource fileLocalDataSource;

    public void setFileLocalDataSource(FileLocalDataSource fileLocalDataSource) {
        this.fileLocalDataSource = fileLocalDataSource;
    }

    @Override
    public void deleteLibro(String id) {

        fileLocalDataSource.delete(id);

    }

    @Override
    public Libro showLibro(String id) {
        return fileLocalDataSource.findById(id);
    }

    @Override
    public void saveLibro(Libro libro) {

        fileLocalDataSource.save(libro);

    }

    @Override
    public List<Libro> showAllLibros() {
        return fileLocalDataSource.findAll();
    }
}
