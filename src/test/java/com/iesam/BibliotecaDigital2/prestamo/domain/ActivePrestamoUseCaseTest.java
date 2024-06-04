package com.iesam.BibliotecaDigital2.prestamo.domain;

import com.iesam.bibliotecaDigital2.libro.domain.Libro;
import com.iesam.bibliotecaDigital2.prestamo.domain.GetAllPrestamos;
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

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class ActivePrestamoUseCaseTest {

    @Mock
    PrestamoRespository prestamoRespository;
    GetAllPrestamos getAllPrestamos;

    @BeforeEach
    void setUp() {
        getAllPrestamos= new GetAllPrestamos (prestamoRespository);
    }


    @AfterEach
    void tearDown() {
        getAllPrestamos = null;
    }
    @Test
    void cuandoCreamosListaDePrestamosParaVerSiSonActivos() {

        // declaracion de las variables
        List<Prestamo> prestamoEsperado = new ArrayList<>();
        Usuario usuario = new Usuario("45","alberto","567");
        Libro libro = new Libro("3","caballero","realidad","kruff","edad media");
        prestamoEsperado.add(new Prestamo("453",usuario,libro));
        prestamoEsperado.add(new Prestamo("1243",usuario,libro));
        Mockito.when(prestamoRespository.allPrestamos()).thenReturn(prestamoEsperado);

        // when
        List <Prestamo> prestamoRecibido = getAllPrestamos.execute();

        // then
        Assertions.assertEquals(prestamoEsperado.size(),prestamoRecibido.size());
        for( int i= 1; i<prestamoEsperado.size();i++){
            Prestamo esperado = prestamoEsperado.get(i);
            Prestamo recibido = prestamoRecibido.get(i);



            Assertions.assertEquals(esperado.id, recibido.id);
            // comparo los atributos de usuario mediante las variables creadas

            Assertions.assertEquals(esperado.usuario.dni, usuario.dni);
            Assertions.assertEquals(esperado.usuario.nombre, usuario.nombre);
            Assertions.assertEquals(esperado.usuario.numeroTelefono, usuario.numeroTelefono);
            // hago lo mismo com libro
            Assertions.assertEquals(esperado.libro.id, libro.id);
            Assertions.assertEquals(esperado.libro.titulo, libro.titulo);
            Assertions.assertEquals(esperado.libro.genero, libro.genero);
            Assertions.assertEquals(esperado.libro.autor, libro.autor);
            Assertions.assertEquals(esperado.libro.descripcion, libro.descripcion);
        }



    }
    @Test
    public void cuandoObtengoLaListaDePrestamosActivosYEstaVacia() {
        //Given: Declaración de variables
        List<Prestamo> prestamoEsperado = new ArrayList<>();
        Mockito.when(prestamoRespository.allPrestamos()).thenReturn(prestamoEsperado);

        //Then
        List<Prestamo> prestamoVacio = getAllPrestamos.execute();

        //Then
        Assertions.assertEquals(0, prestamoVacio.size());
    }


}