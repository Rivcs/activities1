package es.uvigo.esei.aed1.activity2.linkedWith2References;

import es.uvigo.esei.aed1.commonLinked.Node;

public class LinkedWith2References {
  private Node first;
  private Node last;
  private int numOfValues;

  public LinkedWith2References() {
    this.first = null;
    this.last = null;
    this.numOfValues = 0;
  }

  public boolean isEmpty() {

    return numOfValues == 0;
  }

  public int size() {

    return numOfValues;
  }

  public int numberOfOccurrences(int value) {
    int count = 0;
    for (Node current = this.first; current != null; current = current.getNext()) {
      if (current.hasValue(value)) {
        count++;
      }
    }
    return count;
  }

  public boolean contains(int value) {
    Node current = this.first;
    while (current != null && !current.hasValue(value)) {
      current = current.getNext();
    }
    return current != null;
  }

  public void addFirst(int value) {
    Node newNode = new Node(value, this.first);
    if (this.isEmpty()) {
      this.first = newNode;
      this.last = newNode;
    } else {
      this.first = newNode;
    }
    this.numOfValues++;
  }

  public void addLast(int value) {
    Node newNode = new Node(value, null);
    if (this.isEmpty()) {
      this.first = newNode;
      this.last = newNode;
    } else {
      this.last.setNext(newNode);
      this.last = newNode;
    }
    this.numOfValues++;
  }

  public void remove(int value) {
    if (this.isEmpty()) {
      System.out.println("La estructura ya está vacía");
    } else if (this.first.hasValue(value)) { // Borrar el primer nodo si tiene el valor
      this.first = this.first.getNext();
      if (this.first == null) { // Si es el único nodo en la lista
        this.last = null;
      }
      numOfValues--;
    } else {
      // Buscar el nodo con el valor
      Node current = this.first;
      while (current.getNext() != null && !current.getNext().hasValue(value)) {
        current = current.getNext();
      }
      if (current.getNext() != null) {
        if (current.getNext() == this.last) { // Borrar el último nodo si tiene el valor
          current.setNext(null);
          this.last = current;
        } else { // Borrar un nodo del medio si tiene el valor
          current.setNext(current.getNext().getNext());
        }
        numOfValues--;
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (Node current = this.first; current != null; current = current.getNext()) {
      sb.append(current.getValue()).append(" ");
    }
    return sb.toString();
  }
}
