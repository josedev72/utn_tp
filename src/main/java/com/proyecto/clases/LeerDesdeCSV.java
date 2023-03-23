package com.proyecto.clases;

public class LeerDesdeCSV {
}
/*
En caso de que el archivo CSV contenga resultados de partidos de fútbol, podrías utilizar una clase Java que represente un partido y que tenga los atributos necesarios para almacenar los datos del partido, como los nombres de los equipos, los goles marcados y el resultado final.

Aquí te presento un ejemplo de cómo podrías definir esta clase:

public class Partido {
   private String equipoLocal;
   private String equipoVisitante;
   private int golesEquipoLocal;
   private int golesEquipoVisitante;
   private ResultadoPartido.Resultado resultado;

   public Partido(String equipoLocal, String equipoVisitante, int golesEquipoLocal, int golesEquipoVisitante) {
      this.equipoLocal = equipoLocal;
      this.equipoVisitante = equipoVisitante;
      this.golesEquipoLocal = golesEquipoLocal;
      this.golesEquipoVisitante = golesEquipoVisitante;
      this.resultado = ResultadoPartido.obtenerResultado(golesEquipoLocal, golesEquipoVisitante);
   }

   public String getEquipoLocal() {
      return equipoLocal;
   }

   public String getEquipoVisitante() {
      return equipoVisitante;
   }

   public int getGolesEquipoLocal() {
      return golesEquipoLocal;
   }

   public int getGolesEquipoVisitante() {
      return golesEquipoVisitante;
   }

   public ResultadoPartido.Resultado getResultado() {
      return resultado;
   }
}
En este ejemplo, la clase Partido tiene los atributos equipoLocal, equipoVisitante, golesEquipoLocal, golesEquipoVisitante y resultado. El constructor de la clase recibe como parámetros los datos del partido y utiliza el método obtenerResultado() de la clase ResultadoPartido para obtener el resultado final del partido.

Además, la clase Partido tiene métodos get para acceder a los atributos del partido.

Para leer el archivo CSV y crear objetos de la clase Partido, puedes utilizar el código que se muestra en la respuesta anterior. En lugar de agregar los datos a un arreglo de cadenas, puedes crear un objeto de la clase Partido con los datos de cada línea del archivo CSV y agregarlo a un ArrayList:

ArrayList<Partido> partidos = new ArrayList<>();

try (Scanner scanner = new Scanner(new File("resultados.csv"))) {
   scanner.useDelimiter(",|\\n");
   while (scanner.hasNext()) {
      String equipoLocal = scanner.next();
      String equipoVisitante = scanner.next();
      int golesEquipoLocal = scanner.nextInt();
      int golesEquipoVisitante = scanner.nextInt();
      Partido partido = new Partido(equipoLocal, equipoVisitante, golesEquipoLocal, golesEquipoVisitante);
      partidos.add(partido);
   }
} catch (FileNotFoundException ex) {
   System.out.println("Error al leer el archivo: " + ex.getMessage());
}
En este ejemplo, se utiliza el método nextInt() de la clase Scanner para leer los goles marcados por cada equipo. Luego, se crea un objeto de la clase Partido con los datos leídos y se agrega a un ArrayList llamado partidos.

Una vez que tienes los objetos de la clase Partido almacenados en el ArrayList, puedes acceder a sus atributos y utilizarlos para realizar diversas operaciones, como mostrar los resultados de los partidos o calcular estadísticas.
 */

/*
Para leer un archivo CSV y pasarlo a un arreglo utilizando la biblioteca OpenCSV, puedes utilizar la clase CSVReader y su método readAll() para obtener todos los registros del archivo CSV. Aquí te presento un ejemplo:

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.opencsv.CSVReader;

public class LeerCSV {
   public static void main(String[] args) {
      // Crear un arreglo para almacenar los datos del archivo CSV
      String[][] datos = null;

      // Leer el archivo CSV
      try (CSVReader reader = new CSVReader(new FileReader("datos.csv"))) {
         List<String[]> registros = reader.readAll();
         datos = registros.toArray(new String[0][0]);
      } catch (IOException ex) {
         System.out.println("Error al leer el archivo: " + ex.getMessage());
      }

      // Mostrar el arreglo en la consola
      for (String[] linea : datos) {
         for (String valor : linea) {
            System.out.print(valor + " ");
         }
         System.out.println();
      }
   }
}
En este ejemplo, se crea un arreglo bidimensional datos para almacenar los registros del archivo CSV. Luego, se utiliza la clase CSVReader para leer el archivo CSV. El método readAll() de la clase CSVReader devuelve una lista de registros, donde cada registro es un arreglo de cadenas que representa una línea del archivo CSV.

Después de leer el archivo CSV, se convierte la lista de registros a un arreglo bidimensional utilizando el método toArray() de la lista. Finalmente, se muestra el arreglo en la consola.

Ten en cuenta que en este ejemplo, cada línea del archivo CSV se convierte en un arreglo de cadenas, pero no se realiza ningún procesamiento de los datos. Si necesitas realizar alguna operación con los datos del archivo CSV, deberás modificar el código para procesar los datos de acuerdo a tu necesidad.

Además, para utilizar la biblioteca OpenCSV, deberás agregar la dependencia correspondiente en el archivo pom.xml de tu proyecto si estás utilizando Maven, o descargar la biblioteca y agregarla al classpath de tu proyecto si estás utilizando otro sistema de gestión de dependencias o si estás trabajando sin uno.
 */

/*
Para leer los dos archivos CSV que contienen datos de equipos y goles, y almacenarlos en dos arreglos distintos, puedes utilizar la biblioteca OpenCSV y la clase que definimos anteriormente Partido. Aquí te presento un ejemplo:

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

public class LeerCSV {
   public static void main(String[] args) {
      // Crear un ArrayList para almacenar los partidos de los pronósticos
      ArrayList<Partido> pronosticos = new ArrayList<>();

      // Leer el archivo de pronósticos
      try (CSVReader reader = new CSVReader(new FileReader("pronosticos.csv"))) {
         List<String[]> registros = reader.readAll();
         for (String[] registro : registros) {
            String equipoLocal = registro[0];
            String equipoVisitante = registro[2];
            int golesEquipoLocal = Integer.parseInt(registro[1]);
            int golesEquipoVisitante = Integer.parseInt(registro[3]);
            Partido partido = new Partido(equipoLocal, equipoVisitante, golesEquipoLocal, golesEquipoVisitante);
            pronosticos.add(partido);
         }
      } catch (IOException ex) {
         System.out.println("Error al leer el archivo de pronósticos: " + ex.getMessage());
      }

      // Crear un ArrayList para almacenar los partidos de los resultados
      ArrayList<Partido> resultados = new ArrayList<>();

      // Leer el archivo de resultados
      try (CSVReader reader = new CSVReader(new FileReader("resultados.csv"))) {
         List<String[]> registros = reader.readAll();
         for (String[] registro : registros) {
            String equipoLocal = registro[0];
            String equipoVisitante = registro[2];
            int golesEquipoLocal = Integer.parseInt(registro[1]);
            int golesEquipoVisitante = Integer.parseInt(registro[3]);
            Partido partido = new Partido(equipoLocal, equipoVisitante, golesEquipoLocal, golesEquipoVisitante);
            resultados.add(partido);
         }
      } catch (IOException ex) {
         System.out.println("Error al leer el archivo de resultados: " + ex.getMessage());
      }

      // Comparar los resultados y los pronósticos
      compararResultados(pronosticos, resultados);
   }

   public static void compararResultados(ArrayList<Partido> pronosticos, ArrayList<Partido> resultados) {
      // Recorrer los arreglos y comparar los resultados
      for (int i = 0; i < pronosticos.size(); i++) {
         Partido pronostico = pronosticos.get(i);
         Partido resultado = resultados.get(i);
         System.out.println("Partido: " + pronostico.getEquipoLocal() + " vs " + pronostico.getEquipoVisitante());
         System.out.println("Pronóstico: " + pronostico.getGolesEquipoLocal() + "-" + pronostico.getGolesEquipoVisitante() + ", Resultado: " + resultado.getGolesEquipoLocal() + "-" + resultado.getGolesEquipoVisitante());
         if (pronostico.getGolesEquipoLocal() == resultado.getGolesEquipoLocal() && pronostico.getGolesEquipoVisitante() == resultado.getGolesEquipoVisitante()) {
            System.out.println("El pronóstico es correcto.");
         } else {
            System.out.println("El pronóstico es incorrecto.");
         }
         System.out.println();
      }
   }
}
En este ejemplo, se crean dos arreglos pronosticos y resultados para almacenar los partidos de los pronósticos y los resultados, respectivamente. Se utilizan las mismas técnicas que se explicaron anteriormente para leer los archivos CSV y crear objetos de la clase Partido con los datos de cada línea.

Una vez que se tienen los dos arreglos de partidos, se pueden comparar los pronósticos con los resultados utilizando el método compararResultados(). Este método recibe como parámetros los dos arreglos de partidos y los recorre para comparar los resultados. En este ejemplo, se muestra el resultado de cada comparación en la consola.

Ten en cuenta que en este ejemplo, se asume que el archivo de pronósticos y el archivo de resultados tienen la misma cantidad de partidos y que los partidos están en el mismo orden. Si estos supuestos no se cumplen, deberás modificar el código para adaptarlo a tus necesidades.
 */