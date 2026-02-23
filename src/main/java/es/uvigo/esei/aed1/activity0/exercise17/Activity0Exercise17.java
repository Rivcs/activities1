
package es.uvigo.esei.aed1.activity0.exercise17;

import java.util.Scanner;

public class Activity0Exercise17 {
  static Scanner entrada = new Scanner(System.in);

  // exercise 17
  /**
   * muestra un mensaje por pantalla y lee un número entero de teclado
   * 
   * @param message el mensaje a visualizar
   * @return el número entero leido de teclado
   */
  public static int readNumber(String mensaje) {
    System.out.println(mensaje);
    int numero = Integer.parseInt(entrada.nextLine());
    return numero;

  }

  /**
   * muestra un mensaje por pantalla y lee un número real de teclado
   * 
   * @param message el mensaje a visualizar
   * @return el número real leido de teclado
   */
  public static double readDouble(String message) {
    System.out.println(message);
    double numero = Double.parseDouble(entrada.nextLine());
    return numero;
  }

  /**
   * muestra un mensaje por pantalla y lee una matriz de números reales
   * 
   * @param matrix  que almacena números reales
   * @param message el mensaje a visualizar
   */
  public static void readNotes(double[][] matrix, String message) {
    System.out.println(message);
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        matrix[i][j] = readDouble("Introduzca la nota" + (j + 1) + " del alumno" + (i + 1));
      }
    }
  }

  /**
   * muestra por pantalla un mensaje y el contenido de una matriz de números
   * reales
   * 
   * @param matrix  que almacena numeros reales
   * @param message el mensaje a visualizar
   */
  public static void printNotes(double[][] matrix, String message) {
    System.out.println(message);
    for (int i = 0; i < matrix.length; i++) {
      System.out.println("Estudiante " + (i + 1));

      for (int j = 0; j < matrix[i].length; j++) {
        System.out.println(matrix[i][j]);
      }
    }
  }
}
