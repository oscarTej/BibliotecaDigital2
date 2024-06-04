package com.iesam.bibliotecaDigital2.prestamo.presentation;

import com.iesam.bibliotecaDigital2.libro.data.LibroDataRepository;
import com.iesam.bibliotecaDigital2.libro.data.Local.LibroFileLocalDataSource;
import com.iesam.bibliotecaDigital2.libro.domain.DeleteLibroUseCase;
import com.iesam.bibliotecaDigital2.libro.domain.GetLibroUseCase;
import com.iesam.bibliotecaDigital2.libro.domain.Libro;
import com.iesam.bibliotecaDigital2.libro.presentation.LibroPresentation;
import com.iesam.bibliotecaDigital2.prestamo.data.PrestamoDataRepository;
import com.iesam.bibliotecaDigital2.prestamo.data.local.PrestamoFileLocalDataSource;
import com.iesam.bibliotecaDigital2.prestamo.domain.*;
import com.iesam.bibliotecaDigital2.usuario.data.UsuarioDataRepository;
import com.iesam.bibliotecaDigital2.usuario.data.local.UsuarioFileLocalDataSource;
import com.iesam.bibliotecaDigital2.usuario.domain.GetUsuarioUseCase;
import com.iesam.bibliotecaDigital2.usuario.domain.Usuario;
import com.iesam.bibliotecaDigital2.usuario.presentation.UsuarioPresentation;

import java.text.SimpleDateFormat;
import java.util.*;

public class PrestamoPresentation {

    static Scanner input = new Scanner(System.in);
    public static void menuPrestamo(){
        int opcion;

        do{
            System.out.println("------Menu Prestamos-----");
            System.out.println("1. crear prestamo");
            System.out.println("2. borrar prestamo");
            System.out.println("3. mostrar prestamo por id");
            System.out.println("4. esta el prestamo activo");
            System.out.println("5. ver el estado del prestamo");
            System.out.println("elige la opcion");

            opcion= input.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Salir");
                    break;
                case 1:
                    System.out.println("has seleccionado crear prestamo");
                    save();
                    break;
                case 2:
                    System.out.println("has seleccionado borrar prestamo");
                    deletePrestamo();
                    break;
                case 3:
                    System.out.println("has seleccionado mostrar prestamo");
                    getPrestamo();
                    break;
                case 4:
                    System.out.println("has seleccionado mostrar todos prestamo");
                    getAllPrestamos();
                    break;
                case 5:
                    System.out.println("vamos a ver el estado de el prestamo");
                    prestamoActivo();
                    break;
                default:
                    System.out.println("opcion no valida");
            }
        }while (opcion!=0);
    }
    public static void save(){
        System.out.println("introduce el id del usuario");
        String dni = input.next();
        GetUsuarioUseCase getUsuarioUseCase = new GetUsuarioUseCase(
                new UsuarioDataRepository(new UsuarioFileLocalDataSource()));
        Usuario usuario = getUsuarioUseCase.execute(dni);
        System.out.println("introduce los id del libro");
        String id = input.next();
        GetLibroUseCase getLibroUseCase = new GetLibroUseCase(new
                LibroDataRepository(new LibroFileLocalDataSource()));
        Libro libro = getLibroUseCase.execute(id);

        id = usuario.dni + "" + libro.id;

        Prestamo prestamo = new Prestamo( id,usuario,libro );
        System.out.println("Acabas de crear este prestamo\n" + prestamo.fechaPrestamo);
        SavePrestamoUseCase savePrestamoUseCase = new SavePrestamoUseCase(new PrestamoDataRepository(new PrestamoFileLocalDataSource()));
        savePrestamoUseCase.execute(prestamo);

    }
    public static void deletePrestamo (){
        System.out.println("introduce el id del prestamo que deseas eliminar");
        String id = input.next();
        DeletePrestamoUseCase deletePrestamoUseCase = new DeletePrestamoUseCase(
                new PrestamoDataRepository(new PrestamoFileLocalDataSource()));
        deletePrestamoUseCase.execute(id);


        System.out.println("el prestamo eliminado es "+ id);
    }

    public static List<Prestamo> getAllPrestamos(){
        GetAllPrestamos getAllPrestamos = new GetAllPrestamos(
                new PrestamoDataRepository(new PrestamoFileLocalDataSource()));

        List<Prestamo> Prestamos = getAllPrestamos.execute();

        for(Prestamo prestamo : Prestamos){
            System.out.println(prestamo);
        }
        return Prestamos;
    }

    public static Prestamo getPrestamo(){
        System.out.println("introduce el id del prestamo");
        String id = input.next();
        GetPrestamoUseCase getPrestamoUseCase = new GetPrestamoUseCase(new
                PrestamoDataRepository(new PrestamoFileLocalDataSource()));
         Prestamo prestamo= getPrestamoUseCase.execute(id);

         System.out.println(prestamo);
        return prestamo;

    }
    public static void prestamoActivo(){

        System.out.println("introduce el id del prestamo");
        String id = input.next();
        ActivePrestamoUseCase activePrestamoUseCase = new ActivePrestamoUseCase(
                new PrestamoDataRepository(new PrestamoFileLocalDataSource()));
        if (activePrestamoUseCase.execute(id)){
            System.out.println(" esta activo");
        } else {

            System.out.println(" esta inactivo");
        }



    }
}
