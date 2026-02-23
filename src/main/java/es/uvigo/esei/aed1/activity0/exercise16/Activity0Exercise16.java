
package es.uvigo.esei.aed1.activity0.exercise16;

import java.util.Scanner;

public class Activity0Exercise16 {
  static Scanner entrada = new Scanner(System.in);
  // exercise 16

  /**
   * Calcula el maximo de los enteros almacenados en el array
   * 
   * @param array contiene los enteros
   * @return el valor mínimo
   */
  public static int maximum(int[] array) {
    int maximum = array[0];
    for (int i = 0; i < array.length; i++) {
      if (maximum < array[i]) {
        maximum = array[i];
      }
    }
    System.out.println(maximum);
    return 0;
  }

  /**
   * Calcula el mínimo de los enteros almacenados en el array
   * 
   * @param array contiene los enteros
   * @return el valor mínimo
   */
  public static int minimum(int[] array) {
    int minimum = array[0];
    for (int i = 0; i < array.length; i++) {
      if (minimum > array[i]) {
        minimum = array[i];
      }
    }
    System.out.println(minimum);
    return 0;
  }

  /**
   * Calcula el promedio de los enteros almacenados en el array
   * 
   * @param array contiene los enteros
   * @return el valor promedio
   */
  public static double average(int[] array) {
    int average;
    int sumaEnteros = 0;

    for (int i = 0; i < array.length; i++) {
      sumaEnteros += array[i];
    }
    average = sumaEnteros / array.length;
    System.out.println(average);

    return 0;
  }

  public static int readInteger(String message) {

    return 0;
  }

  /**
   * almacena enteros en el array haciendo uso del método readInteger
   * 
   * @param array que almacenará los enteros
   */
  public static void readArray(int[] array) {
    System.out.println("Indica el numero de elementos del array");
    int numeroElementos = Integer.parseInt(entrada.nextLine());
    for (int i = 0; i < numeroElementos; i++) {
      System.out.println("Indica el numero " + (i+1) + "del array");
      array[i] = Integer.parseInt(entrada.nextLine());
    }

  }

}
