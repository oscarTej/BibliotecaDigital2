package com.iesam.BibliotecaDigital2.prestamo.domain;

import com.iesam.bibliotecaDigital2.prestamo.domain.DeletePrestamoUseCase;
import com.iesam.bibliotecaDigital2.prestamo.domain.PrestamoRespository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class DeletePrestamoUseCaseTest {



        @Mock
        PrestamoRespository prestamoRespository;
        DeletePrestamoUseCase deletePrestamoUseCase;

        @BeforeEach
        void setUp() {
            deletePrestamoUseCase = new DeletePrestamoUseCase(prestamoRespository);
        }

        @AfterEach
        void tearDown() {
            deletePrestamoUseCase = null;
        }

        @Test
        void cuandoEscriboElIdYElPrestamoSeBorraCorrectamente() {
            // delcaramos la variable
            String id = "2";
            //when
            deletePrestamoUseCase.execute(id);

            //then
            Mockito.verify(prestamoRespository,Mockito.times(1)).deletePrestamo(id);
        }
}

