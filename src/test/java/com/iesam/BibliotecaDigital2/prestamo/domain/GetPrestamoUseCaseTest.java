package com.iesam.BibliotecaDigital2.prestamo.domain;

import com.iesam.bibliotecaDigital2.libro.domain.Libro;
import com.iesam.bibliotecaDigital2.prestamo.domain.GetPrestamoUseCase;
import com.iesam.bibliotecaDigital2.prestamo.domain.Prestamo;
import com.iesam.bibliotecaDigital2.prestamo.domain.PrestamoRespository;
import com.iesam.bibliotecaDigital2.usuario.domain.Usuario;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class GetPrestamoUseCaseTest {

    @Mock
    PrestamoRespository prestamoRespository;
    GetPrestamoUseCase getPrestamoUseCase;

    @BeforeEach
    void setUp() {
        getPrestamoUseCase = new GetPrestamoUseCase(prestamoRespository);
    }

    @AfterEach
    void tearDown() {
        getPrestamoUseCase = null;
    }

    @Test
    void CuandoIntroduzcoElIdCorrectoMeDevuelveElPrestamo() {

        String idCorrecto = "12";
        Usuario usuario = new Usuario("1","oscar","3456789");
        Libro libro = new Libro("2","hola mundo","ciencia","pablo","bonito");
        Prestamo prestamoEnvio = new Prestamo("12",usuario,libro);
        Mockito.when(prestamoRespository.getPrestamoId(idCorrecto)).thenReturn(prestamoEnvio);

        //when
        Prestamo recibePrestamo = getPrestamoUseCase.execute(idCorrecto);

        // then
       Assertions.assertEquals(recibePrestamo.id,"12");

        // comparo los atributos de usuario
        Assertions.assertEquals(recibePrestamo.usuario.dni, usuario.dni);
        Assertions.assertEquals(recibePrestamo.usuario.nombre, usuario.nombre);
        Assertions.assertEquals(recibePrestamo.usuario.numeroTelefono, usuario.numeroTelefono);

        // comparo los atributos del libro
        Assertions.assertEquals(recibePrestamo.libro.id, libro.id);
        Assertions.assertEquals(recibePrestamo.libro.autor, libro.autor);
        Assertions.assertEquals(recibePrestamo.libro.descripcion, libro.descripcion);
        Assertions.assertEquals(recibePrestamo.libro.titulo, libro.titulo);
        Assertions.assertEquals(recibePrestamo.libro.genero, libro.genero);
    }

    @Test
    void cuandoIntroduzcoIdIncorrectoMeDevuelveUnNull() {
        // delcaracion de variables

        String idIncorrecto = "234253";
        Mockito.when(prestamoRespository.getPrestamoId(idIncorrecto)).thenReturn(null);

        // when
        Prestamo recibePrestamo = getPrestamoUseCase.execute(idIncorrecto);

        // then
        Assertions.assertNull(recibePrestamo);
    }
}