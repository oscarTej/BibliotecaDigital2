package com.iesam.BibliotecaDigital2.prestamo.domain;

import com.iesam.bibliotecaDigital2.libro.domain.Libro;
import com.iesam.bibliotecaDigital2.prestamo.domain.GetAllPrestamos;
import com.iesam.bibliotecaDigital2.prestamo.domain.Prestamo;
import com.iesam.bibliotecaDigital2.prestamo.domain.PrestamoRespository;
import com.iesam.bibliotecaDigital2.prestamo.domain.SavePrestamoUseCase;
import com.iesam.bibliotecaDigital2.usuario.domain.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class SavePrestamoUseCaseTest {
    @Mock
    PrestamoRespository prestamoRespository;
    SavePrestamoUseCase savePrestamoUseCase;

    @BeforeEach
    void setUp() {
        savePrestamoUseCase = new SavePrestamoUseCase(prestamoRespository);
    }

    @AfterEach
    void tearDown() {
        savePrestamoUseCase = null;
    }

    @Test
    void cuandoGuardoPrestamoSeGuardaCorrectamente() {
        Usuario usuario = new Usuario("34", "javi","5436543");
        Libro libro = new Libro("234","buda","ciencia","oikl","entretenido");
        Prestamo prestamo = new Prestamo("34234",usuario,libro);

        savePrestamoUseCase.execute(prestamo);

        Mockito.verify(prestamoRespository, Mockito.times((1))).savePrestamo(prestamo);

    }


}