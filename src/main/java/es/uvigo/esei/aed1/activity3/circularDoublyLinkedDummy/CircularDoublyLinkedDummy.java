
package es.uvigo.esei.aed1.activity3.circularDoublyLinkedDummy;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class CircularDoublyLinkedDummy {
  private DoubleNode dummy;
  private int size;

  public CircularDoublyLinkedDummy() {
    this.dummy = new DoubleNode(null, -0, null);
    this.dummy.setPrevious(this.dummy);
    this.dummy.setNext(this.dummy);
    this.size = 0;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int size() {
    return this.size;
  }

  public int numberOfOccurrences(int value) {
    int count = 0;
    DoubleNode current = this.dummy.getNext();
    while (current != this.dummy) {
      if (current.hasValue(value)) {
        count++;
      }
      current = current.getNext();
    }
    return count;
  }

  public boolean contains(int value) {
    DoubleNode current = this.dummy.getNext();
    while (current != this.dummy) {
      if (current.hasValue(value)) {
        return true;
      }
      current = current.getNext();
    }
    return false;
  }

  public void addFirst(int value) {
    DoubleNode newNode = new DoubleNode(this.dummy, value, this.dummy.getNext());
    this.dummy.getNext().setPrevious(newNode);
    this.dummy.setNext(newNode);
    this.size++;
  }

  public void addLast(int value) {
    DoubleNode newNode = new DoubleNode(this.dummy.getPrevious(), value, this.dummy);
    this.dummy.getPrevious().setNext(newNode);
    this.dummy.setPrevious(newNode);
    this.size++;
  }

  public void remove(int value) {
    if (this.isEmpty()) {
      System.out.println("La estructura está vacía");
    } else {
      DoubleNode current = this.dummy.getNext();
      while (current != this.dummy && !current.hasValue(value)) {
        current = current.getNext();
      }
      if (current == this.dummy) {
        System.out.println("El valor no se encuentra en la estructura");
      } else {
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        this.size--;
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Valores de los nodos: ");
    DoubleNode current = this.dummy.getNext();
    while (current != this.dummy) {
      sb.append(current.getValue());
    }
    String finalString = sb.toString();
    return finalString;
  }
  
}
