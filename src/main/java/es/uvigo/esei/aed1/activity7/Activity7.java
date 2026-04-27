package es.uvigo.esei.aed1.activity7;

import es.uvigo.esei.aed1.activity7.hospital.Doctor;
import es.uvigo.esei.aed1.activity7.hospital.Hospital;
import es.uvigo.esei.aed1.tads.list.IteratorList;
import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;
import java.util.Iterator;

public class Activity7 {

  // Exercise 1
  public static List<Integer> getHigherThan(List<Integer> listToFilter, int threshold) throws NullPointerException {

    if (listToFilter == null) {
      throw new NullPointerException();
    }

    List<Integer> result = new LinkedList<>();
    for (Integer i : listToFilter) {
      if (i > threshold) {
        result.addLast(i);
      }
    }
    return result;
  }

  // Exercise 2
  public static <T> List<T> invert(List<T> list) throws NullPointerException {

    if (list == null) {
      throw new NullPointerException();
    }
    List<T> result = new LinkedList<>();
    for (T i : list) {
      result.addFirst(i);
    }
    return result;
  }

  // Exercise 3
  private static <T> int countValueAppearances(List<T> list, T referenceValue) {
    int count = 0;
    for (T value : list) {
      if (value.equals(referenceValue)) {
        count++;
      }
    }
    return count;
  }

  public static <T> boolean allValuesAppearancesAreEqual(List<T> list) throws NullPointerException {

    return true;
  }

  // Exercise 4
  public static <T extends Comparable<T>> boolean isAscendingOrder(List<T> list) throws NullPointerException {
    if (list == null) {
      throw new NullPointerException();
    }
    Iterator<T> itr = list.iterator();
    T previous = itr.next();

    while (itr.hasNext()) {
      T value = itr.next();
      if (value.compareTo(previous) > 0) {
        return false;
      }
      previous = value;
    }
    return true;
  }

  // Exercise 5
  public static <T> List<T> buildListWithRepeatedValues(List<T> list) throws NullPointerException {
    return null;
  }

  // Exercise 6
  private static <T> boolean countTuplesWithAValue(List<Terna<T>> list, T value) { // Comprueba si un valor ya existe en
                                                                                   // la lista

    for (Terna<T> t : list) {
      if (!t.getValue().equals(value)) {
        return false;
      }
    }
    return true;
  }

  public static <T> List<Terna<T>> buildSummaryList(List<T> list1, List<T> list2) throws NullPointerException {
    if (list1 == null || list2 == null) {
      throw new NullPointerException();
    }

    List<Terna<T>> summaryList = new LinkedList<>();

    for (T values1 : list1) { // Recorremos la lista 1
      if (countTuplesWithAValue(summaryList, values1) != true) { // Comprueba si un valor ya existe en la lista
        int numTimes1 = countValueAppearances(list1, values1); // Cuenta las apariciones del valor en la lista 1
        int numTimes2 = countValueAppearances(list2, values1); // Cuenta las apariciones del valor en la lista 2
        summaryList.addLast(new Terna<T>(values1, numTimes1, numTimes2)); // Añade la terna a la lista resumen
      }
    }

    for (T values2 : list2) { // Recorremos la lista 2
      if (countTuplesWithAValue(summaryList, values2) != true) { // Comprueba si un valor ya existe en la lista
        int numTimes1 = countValueAppearances(list1, values2); // Cuenta las apariciones del valor en la lista 1
        int numTimes2 = countValueAppearances(list2, values2); // Cuenta las apariciones del valor en la lista 2
        summaryList.addLast(new Terna<T>(values2, numTimes1, numTimes2)); // Añade la terna a la lista resumen
      }
    }

    return summaryList;
  }

  // Exercise 7
  public static int countValuesEqualSumPreceding(List<Integer> list) throws NullPointerException {
    if (list.isEmpty()) {
      throw new NullPointerException();
    }
    int positionsValid = 0;
    int sumBeforeElement = 0;
    for (Integer integer : list) {
      if (integer.equals(sumBeforeElement)) {
        positionsValid++;
      }
      sumBeforeElement += integer;
    }
    return positionsValid;
  }

  // Exercise 8
  public static <T> List<T> printLots(List<T> list, List<Integer> index) throws NullPointerException {
    if (list == null || index == null) {
      throw new NullPointerException();
    }
    List<T> listResult = new LinkedList<>();
    int indexList = 1;
    IteratorList<Integer> itr = index.iteratorList();

    if (!itr.hasNext()) {
      return listResult;
    }

    int targetIndex = itr.next();

    for (T element : list) {
      if (indexList == targetIndex) {
        listResult.addLast(element);
        if (!itr.hasNext()) {
          break;
        }
        targetIndex = itr.next();
      }
      indexList++;
    }
    return listResult;
  }

  // Exercise 9
  public static void duplicateValues(List<Integer> list) throws NullPointerException {
    if (list == null) {
      throw new NullPointerException();
    }
    if (list.isEmpty()) {
      return;
    }
    IteratorList<Integer> itr = list.iteratorList();
    while (itr.hasNext()) {
      Integer value = itr.next();
      itr.setPrevious(value * 2);
    }

  }

  // Exercise 10
  public static Integer getMorePatients(Hospital chuo) {
    int maxPatients = 0;
    int numberOfDoctor = 0;
    for (Doctor doctors : chuo.getDoctors()) {
      int currentPatrients = doctors.getPatients().size();
      if (currentPatrients >= maxPatients) {
        maxPatients = currentPatrients;
        numberOfDoctor = doctors.getNumero();
      }
    }
    return numberOfDoctor;
  }

  // Exercise 11
  // En este ejercicio debes implementar los métodos get y set de la clase
  // es.uvigo.esei.aed1.activity7.sparsematrix.ListNumberSparseMatrix

}
