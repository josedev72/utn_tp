package com.proyecto.clases;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class LeerDesdeCSV {
    String archivoOrigen;

    public LeerDesdeCSV(String archivoOrigen) {
        this.archivoOrigen = archivoOrigen;
    }

    public String getArchivoOrigen() {
        return archivoOrigen;
    }

    public void setArchivoOrigen(String archivoOrigen) {
        this.archivoOrigen = archivoOrigen;
    }


    public static String[][] getPartidos(String archivoOrigen) throws IOException, CsvException {
        int cantColumnas = (int) getColumnas(archivoOrigen);
        System.out.println("cantColumnas: " + cantColumnas);

        int cantFilas = (int) getFilas(archivoOrigen);
        System.out.println("cantFilas: " + cantFilas);

        // Pasar el archivo CSV al arreglo bidimensional
        // Crear un nuevo objeto CSVReader
        CSVReader reader = new CSVReader(new FileReader(archivoOrigen));

        String[][] datos = new String[cantFilas][cantColumnas];

        // Leer todas las líneas del archivo
        List<String[]> lineas = reader.readAll();

        // Crear una nueva matriz de cadenas
        //String[][] datos = new String[lineas.size()][];

        // Copiar las líneas de la lista a la matriz
        String aux="";
        for (int i = 0; i < lineas.size(); i++) {
            datos[i] = lineas.get(i);
        }

        // Cerrar el lector
        reader.close();

        mostrarDatos(datos, cantFilas, cantColumnas);
//
        return datos;
    }

    private static void mostrarDatos(String[][] datos, int cantFilas, int cantColumnas) {
        System.out.println("Datos:");
        String txt="";

        String[] columnas=new String[cantColumnas];
        for (String[] fila : datos){

            // Inicio la salida de consola con corchete de apertura, es solo para presentacion
            System.out.print("[");

            // Con el metodo Arrays.toString(fila) obtengo una cadena con el contenido de la fila
            // pero se agregan al comienzo y fin corchetes
            txt=Arrays.toString(fila);

            // Quito los corchetes del comienzo y fin
            txt=txt.toString().replace("[","");
            txt=txt.toString().replace("]","");

            // Convierto la cadena en String[] (array de cadenas)
            columnas=txt.split(";");
            // Recorrer la columnas obtenidas y mostrarlas por consola
            for (int j=0;j<columnas.length;j++) {
                System.out.print("  " + columnas[j]);
            }

            // Finalizo la salida de consola con corchete de cierre, es solo para presentacion
            System.out.println(" ]");
        }
        System.out.println();
    }

    private static long getColumnas(String archivoOrigen) throws IOException {
        // Se puede usar el método 'readLine()' de la clase '`'BufferedReader' para leer la primera línea
        // de un archivo, que contiene los encabezados de las columnas.
        // Despues, con el método 'split()' de la clase 'String' se puede dividir la
        // línea en una matriz de String.

        // Crear un nuevo objeto BufferedReader
        BufferedReader reader = new BufferedReader(new FileReader(archivoOrigen));

        // Leer la primera línea
        String primeraFila = reader.readLine();

        // Dividir la línea en una matriz de cadenas usando una expresión regular
        String[] encabezados = primeraFila.split("[,;\t]");

        mostrarEncabezados(encabezados);

        return encabezados.length;
    }

    private static void mostrarEncabezados(String[] encabezados) {
        System.out.print("Encabezados: ");
        for (int c = 0; c< encabezados.length; c++){
            System.out.print("  col " + c + ": " + encabezados[c] + ";  ");
        }
        System.out.println();
    }

    private static int getFilas(String archivoOrigen) throws IOException {
        // Crear un nuevo objeto Files
        // Puedes usar el método `readAllLines()` de la clase `Files` para leer
        // todas las líneas de un archivo. Una vez que hayas leído todas las líneas,
        // puedes usar el método `size()` de la interfaz `List` para contar el número de líneas.
        //
        // Leer todas las líneas del archivo
        List<String> lineas = Files.readAllLines(Path.of(archivoOrigen));

        // Contar el número de líneas
        int numeroDeFilas = lineas.size();

        return numeroDeFilas;
    }
}
