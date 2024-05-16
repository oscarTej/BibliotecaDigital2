package com.iesam.bibliotecaDigital2.libro.data.Local;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.iesam.bibliotecaDigital2.libro.domain.Libro;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class FileLocalDataSource {



        private String nameFile = "books.txt";

        private Gson gson = new Gson();

        private final Type typeList = new TypeToken<ArrayList<Libro>>() {
        }.getType();

        public void save(Libro libro) {
            List<Libro> models = findAll();
            models.add(libro);
            saveToFile(models);
        }

        public void saveList(List<Libro> models) {
            saveToFile(models);
        }

        private void saveToFile(List<Libro> models) {
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

        public Libro findById(String id) {
            List<Libro> models = findAll();
            for (Libro model : models) {
                if (Objects.equals(model.id, id)) {
                    return model;
                }
            }
            return null;
        }

        public List<Libro> findAll() {
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
            List<Libro> newList = new ArrayList<>();
            List<Libro> models = findAll();
            for (Libro model : models) {
                newList.add(model);
            }
            saveList(newList);
        }
    }



