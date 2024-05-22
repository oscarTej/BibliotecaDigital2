package com.iesam.bibliotecaDigital2.usuario.data.local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.bibliotecaDigital2.usuario.domain.Usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class UsuarioFileLocalDataSource {

    private String nameFile = "usuario.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<Usuario>>() {
    }.getType();

    public void save(Usuario model) {
        List<Usuario> models = findAll();
        models.add(model);
        saveToFile(models);
    }

    public void saveList(List<Usuario> models) {
        saveToFile(models);
    }

    private void saveToFile(List<Usuario> models) {
        try {
            FileWriter myWriter = new FileWriter(nameFile);
            myWriter.write(gson.toJson(models));
            myWriter.close();
            System.out.println("Datos guardados correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al guardar la información.");
            e.printStackTrace();
        }
    }

    public Usuario findById(String id) {
        List<Usuario> models = findAll();
        for (Usuario model : models) {
            if (Objects.equals(model.dni, id)) {
                return model;
            }
        }
        return null;
    }

    public List<Usuario> findAll() {
        try {
            File myObj = new File(nameFile);
            if (!myObj.exists()) {
                myObj.createNewFile();
            }
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                return gson.fromJson(data, typeList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Ha ocurrido un error al obtener el listado.");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al crear el fichero.");
            throw new RuntimeException(e);
        }
        return new ArrayList<>();
    }

    public void delete(String modelId) {
        List<Usuario> newList = new ArrayList<>();
        List<Usuario> models = findAll();
        for (Usuario model : models) {
            if (!model.dni.equals(modelId)) {

                newList.add(model);
            }
        }
        saveList(newList);
    }

    public void updateUser(Usuario updatedUser) {
        // Obtén todos los usuarios
        List<Usuario> Usuarios = findAll();

        // Busca el usuario que deseas actualizar y reemplázalo
        for (int i = 0; i < Usuarios.size(); i++) {
            if (Usuarios.get(i).dni.equals(updatedUser.dni)) {
                Usuarios.set(i, updatedUser);
                break;
            }
        }
    }

}
