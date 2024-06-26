package com.iesam.bibliotecaDigital2.prestamo.data.local;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.bibliotecaDigital2.prestamo.domain.Prestamo;

public class PrestamoFileLocalDataSource {

    private String nameFile = "Prestamo.txt";

    private Gson gson = new Gson();

    private final Type typeList = new TypeToken<ArrayList<Prestamo>>() {
    }.getType();

    public void save(Prestamo prestamo) {
        List<Prestamo> models = findAll();
        models.add(prestamo);
        saveToFile(models);
    }

    public void saveList(List<Prestamo> models) {
        saveToFile(models);
    }

    private void saveToFile(List<Prestamo> models) {
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

    public Prestamo findById(String id) {
        List<Prestamo> models = findAll();
        for (Prestamo model : models) {
            if (Objects.equals(model.id, id)) {
                return model;
            }
        }
        return null;
    }

    public List<Prestamo> findAll() {
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

    public void delete(String id) {
        List<Prestamo> newList = new ArrayList<>();
        List<Prestamo> models = findAll();
        for (Prestamo model : models) {
            if (!model.id.equals(id))
                newList.add(model);
        }
        saveList(newList);
    }

   /* public boolean activo(String id){
        Prestamo prestamo= findById(id);
        if (prestamo != null){
            return prestamo.equals(prestamo.EstadoDelPrestamo());

        } else {
            System.out.println("no se ha encontrado");
        }return false;

    }

    */


}
