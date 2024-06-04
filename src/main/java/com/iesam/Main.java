package com.iesam;

import com.iesam.bibliotecaDigital2.libro.presentation.LibroPresentation;

import com.iesam.bibliotecaDigital2.prestamo.presentation.PrestamoPresentation;
import com.iesam.bibliotecaDigital2.usuario.presentation.UsuarioPresentation;

public class Main {

    public static void main(String[] args) {

        PrestamoPresentation.menuPrestamo();
        UsuarioPresentation.menuUsuario();
        LibroPresentation.menuLibro();





    }
}
