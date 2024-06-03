package com.iesam.bibliotecaDigital2.prestamo.data;

import com.iesam.bibliotecaDigital2.prestamo.data.local.PrestamoFileLocalDataSource;
import com.iesam.bibliotecaDigital2.prestamo.domain.Prestamo;
import com.iesam.bibliotecaDigital2.prestamo.domain.PrestamoRespository;

import java.util.List;

public class PrestamoDataRepository implements PrestamoRespository {

    public final PrestamoFileLocalDataSource prestamoFileLocalDataSource;

    public PrestamoDataRepository(PrestamoFileLocalDataSource prestamoFileLocalDataSource) {
        this.prestamoFileLocalDataSource = prestamoFileLocalDataSource;
    }

    @Override
    public Prestamo getPrestamoId(Prestamo id) {
      return   prestamoFileLocalDataSource.findById(id);
    }

    @Override
    public void savePrestamo(Prestamo prestamo) {
        prestamoFileLocalDataSource.save(prestamo);

    }

    @Override
    public void deletePrestamo(String id) {
    prestamoFileLocalDataSource.delete(id);
    }

    @Override
    public List<Prestamo> allPrestamos() {
     return prestamoFileLocalDataSource.findAll();
    }
}
