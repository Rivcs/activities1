
package es.uvigo.esei.aed1.activity2.doublyLinked;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;

public class DoublyLinked {

  private DoubleNode first;
  private DoubleNode last;
  private int numOfValues;

  public DoublyLinked() {
    this.first = null;
    this.last = null;
    numOfValues = 0;
  }

  public boolean isEmpty() {
    return numOfValues == 0;
  }

  public int size() {
    return numOfValues;
  }

  public int numberOfOccurrences(int value) {
    int count = 0;
    for (DoubleNode current = this.first; current != null; current = current.getNext()) {
      if (current.hasValue(value)) {
        count++;
      }
    }
    return count;
  }

  public boolean contains(int value) {
    DoubleNode current = this.first;
    while (current != null && !current.hasValue(value)) {
      current = current.getNext();
    }
    return current != null;
  }

  public void addFirst(int value) {
    DoubleNode newNode = new DoubleNode(null, value, this.first);
    if (this.isEmpty()) {
      this.last = newNode;
    } else {
      this.first.setPrevious(newNode);
    }
    this.first = newNode;
    numOfValues++;
  }

  public void addLast(int value) {
    DoubleNode newNode = new DoubleNode(this.last, value, null);
    if (this.isEmpty()) {
      this.first = newNode;
    } else {
      this.last.setNext(newNode);
    }
    this.last = newNode;
    numOfValues++;
  }

  public void remove(int value) {
    if (this.isEmpty()) {
      System.out.println("La lista ya esta vacía");
    } else if (this.first.hasValue(value)) {
      this.first = this.first.getNext();
      if (this.first != null) {
        this.first.setPrevious(null);
      } else {
        this.last = null;
      }
      numOfValues--;
    } else if (this.last.hasValue(value)) {
      this.last = this.last.getPrevious();
      if (this.last != null) {
        this.last.setNext(null);
      } else {
        this.first = null;
      }
      numOfValues--;
    } else {
      DoubleNode current = this.first.getNext();
      while (current != null && !current.hasValue(value)) {
        current = current.getNext();
      }
      if (current != null) {
        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        numOfValues--;
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (DoubleNode current = this.first; current != null; current = current.getNext()) {
      sb.append(current.getValue()).append(" ");
    }
    return sb.toString();
  }

}
