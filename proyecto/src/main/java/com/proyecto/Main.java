package com.proyecto;
//import com.proyecto.clases.LeerDesdeCSV;

import com.opencsv.exceptions.CsvException;
import com.opencsv.exceptions.CsvValidationException;
import com.proyecto.clases.LeerDesdeCSV;

import java.io.IOException;



public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("TP Integrador: Pronóstico ! ! !");

        String rutaArchivo="C:\\Users\\joseg\\utn_java\\resultados.csv";
        String[][] partidos;
        try {
            System.out.println("resultados.csv");
            partidos = LeerDesdeCSV.getPartidos(rutaArchivo);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (CsvException ex) {
            throw new RuntimeException(ex);
        }

        rutaArchivo="C:\\Users\\joseg\\utn_java\\pronostico.csv";
        String[][] pronostico;
        try {
            System.out.println("pronostico.csv");
            pronostico = LeerDesdeCSV.getPartidos(rutaArchivo);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        } catch (CsvException ex) {
            throw new RuntimeException(ex);
        }


    }
}