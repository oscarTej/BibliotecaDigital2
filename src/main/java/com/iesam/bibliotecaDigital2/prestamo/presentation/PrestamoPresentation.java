package com.iesam.bibliotecaDigital2.prestamo.presentation;

import com.iesam.bibliotecaDigital2.libro.domain.Libro;
import com.iesam.bibliotecaDigital2.usuario.domain.Usuario;
import com.iesam.bibliotecaDigital2.usuario.presentation.main;

import java.util.Random;
import java.util.Scanner;

public class PrestamoPresentation {

    static Scanner input = new Scanner(System.in);
    static Random random;
    public static void menuPrestamo(){
        int opcion;

        do{
            System.out.println("------Menu Prestamos-----");
            System.out.println("1. crear prestamo");
            System.out.println("2. borrar prestamo");
            System.out.println("3. mostrar prestamo por id");
            System.out.println("elige la opcion");

            opcion= input.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Salir");
                    break;
                case 1:
                    System.out.println("has seleccionado crear prestamo");
                    break;
                case 2:
                    System.out.println("has seleccionado borrar prestamo");
                    break;
                case 3:
                    System.out.println("has seleccionado mostrar prestamo");
                    break;
                default:
                    System.out.println("opcion no valida");
            }
        }while (opcion!=0);
    }
    public static void save(){
        System.out.println("introduce los datos del usuario");
        Usuario usuario = main.obtainUsuario();
        System.out.println("introduce los datos del libro");
        Libro libro.
    }
}
