package com.iesam.bibliotecaDigital2.usuario.presentation;

import com.iesam.bibliotecaDigital2.usuario.data.UsuarioDataRepository;
import com.iesam.bibliotecaDigital2.usuario.data.local.UsuarioFileLocalDataSource;
import com.iesam.bibliotecaDigital2.usuario.domain.*;

import java.util.List;
import java.util.Scanner;

public class UsuarioPresentation {
    static Scanner input = new Scanner(System.in);

    public static void menuUsuario(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("------Menu Usuario-----");
            System.out.println("0. salir");
            System.out.println("1. Crear usuario");
            System.out.println("2. Borrar usuario");
            System.out.println("3. Obtener listado de usuarios");
            System.out.println("4. Obtener 1 usuario mediante id");
            System.out.println("");
            System.out.println("elige la opcion  ");

            opcion = sc.nextInt();

            switch (opcion) {
                case 0:
                    System.out.println("Salir");
                    break;
                case 1:
                    System.out.println("Has seleccionado crear un usuario.");
                    save();
                    break;
                case 2:
                    System.out.println("Has seleccionado eliminar  un usuario");
                    delete();
                    break;

                case 3:
                    System.out.println("Has seleccionado obtener un listado de usuarios\n");
                    obtainUsuarios();
                    break;
                case 4:
                    System.out.println("Has seleccionado mostrar 1 usuario");
                    obtainUsuario();
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del menú.");
                    break;
            }

        }while ( opcion!=0);

    }
    public static void save(){

        System.out.print("Introduce el dni del usuario: ");
        String dni = input.next();
        System.out.print("Introduce el nombre del usuario: ");
        String nombre = input.next();
        System.out.print("Introduce tu numero de telefono: ");
        String numeroTelefono = input.next();


        Usuario usuario = new Usuario(dni,nombre,numeroTelefono);
        SaveUsuarioUseCase saveUsuarioUseCase = new SaveUsuarioUseCase(
                new UsuarioDataRepository(new UsuarioFileLocalDataSource()));
        saveUsuarioUseCase.execute(usuario);


        System.out.println("se ha guardado correctamente :" + usuario.nombre);
    }

    public static void delete (){

        System.out.println("Introduce el dni del usuario a borrar: ");
        String dni = input.nextLine();
        DeleteUsuarioUseCase deleteUsuarioUseCase = new DeleteUsuarioUseCase(
                new UsuarioDataRepository(new UsuarioFileLocalDataSource()));

        deleteUsuarioUseCase.execute(dni);

        System.out.println("se ha borrado correctamente");

    }
    public static Usuario obtainUsuario (){

        System.out.println("introduce tu dni");
        String dni = input.next();


        GetUsuarioUseCase getUsuarioUseCase = new GetUsuarioUseCase(
                new UsuarioDataRepository(new UsuarioFileLocalDataSource()));
        Usuario usuario = getUsuarioUseCase.execute(dni);

        System.out.println(usuario);

        return usuario;
    }

    public static List<Usuario> obtainUsuarios (){

       GetAllUsuarioUseCase getAllUsuariosUseCase = new GetAllUsuarioUseCase(new
                UsuarioDataRepository(new UsuarioFileLocalDataSource()));

        List<Usuario> Usuarios = getAllUsuariosUseCase.execute();

        for (Usuario usuario : Usuarios){
            System.out.println(usuario);
        }

        return Usuarios;
    }


}
