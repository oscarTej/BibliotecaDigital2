package com.iesam.bibliotecaDigital2.libro.presentation;
import com.iesam.bibliotecaDigital2.libro.data.LibroDataRepository;
import com.iesam.bibliotecaDigital2.libro.data.Local.LibroFileLocalDataSource;
import com.iesam.bibliotecaDigital2.libro.domain.*;
import java.util.List;


import java.awt.*;
import java.util.Scanner;

public class LibroPresentation {


     static Scanner inputLibro= new Scanner(System.in);
    public static void menuLibro(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("------Menu Libro-----");
            System.out.println("0. salir");
            System.out.println("1. añadir libro");
            System.out.println("2. Borrar libro");
            System.out.println("3. Obtener listado de libros");
            System.out.println("4. Obtener 1 libro mediante id");
            System.out.println("");
            System.out.println("elige la opcion  ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Salir");
                    break;
                case 1:
                    System.out.println("Has seleccionado crear un libro.");
                    saveLibro();
                    break;
                case 2:
                    System.out.println("Has seleccionado eliminar  un libro");
                    deleteLibro();
                    break;

                case 3:
                    System.out.println("Has seleccionado obtener un listado de libros\n");
                    showAllLibros();
                    break;
                case 4:
                    System.out.println("Has seleccionado mostrar 1 libro");
                    showLibro();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }

        }while ( opcion!=0);

    }
    public static void saveLibro(){
        System.out.println("dime el id del libro");
        String id = inputLibro.next();
        System.out.println("dime el titulo del libro");
        String titulo = inputLibro.next();
        System.out.println("dime el genero");
        String genero = inputLibro.next();
        System.out.println("dime el autor");
        String autor = inputLibro.next();
        System.out.println("dime la descripcion");
        String descripcion = inputLibro.next();


        Libro libro = new Libro(id,titulo,genero,autor,descripcion);
        SaveLibroUseCase saveLibroUseCase = new SaveLibroUseCase(
                new LibroDataRepository(new LibroFileLocalDataSource()));
        saveLibroUseCase.execute(libro);

        System.out.println("se ha gurdado correctamente:" + libro);


    }
    public static void deleteLibro(){
        System.out.println("introduce el id del libro");
        String id = inputLibro.next();

        DeleteLibroUseCase deleteLibroUseCase = new DeleteLibroUseCase(
                new LibroDataRepository(new LibroFileLocalDataSource()));
        deleteLibroUseCase.execute(id);

        System.out.println("el libro se ha borrado correctamente");
    }
    public static Libro showLibro (){
        System.out.println("indicame el id del libro");
        String id = inputLibro.next();

        GetLibroUseCase getLibroUseCase = new GetLibroUseCase(
                new LibroDataRepository(new LibroFileLocalDataSource()));
        Libro libro = getLibroUseCase.execute(id);
        System.out.println(libro);

        return libro;
    }
   public static List<Libro> showAllLibros(){
         GetAllLibrosUseCase getAllLibrosUseCase = new GetAllLibrosUseCase(
                 new LibroDataRepository(new LibroFileLocalDataSource()));
         List<Libro> Libros = getAllLibrosUseCase.execute();

         for (Libro libro : Libros){
             System.out.println(libro);
         }
         return Libros;
   }




}
