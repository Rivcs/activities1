package es.uvigo.esei.aed1.activity2.circularLinked;

import es.uvigo.esei.aed1.commonLinked.Node;

public class CircularLinked {
  private Node last;
  private int numOfValues;

  public CircularLinked() {
    this.last = null;
    this.numOfValues = 0;
  }

  public boolean isEmpty() {
    return numOfValues == 0;
  }

  public int size() {
    return this.numOfValues;
  }

  public int firstValue() throws NullPointerException {
    if (this.isEmpty()) {
      throw new NullPointerException("La lista está vacía");
    }
    return this.last.getNext().getValue();
  }

  public boolean contains(int value) throws NullPointerException {
    if (this.isEmpty()) {
      throw new NullPointerException("La lista está vacía");
    } else if (this.last.hasValue(value)) {
      return true;
    } else {
      Node current = this.last.getNext();
      while (!current.hasValue(value) && current != this.last) {
        current = current.getNext();
      }
      if (current.hasValue(value)) {
        return true;
      } else {
        return false;
      }
    }
  }

  public int numberOfOccurrences(int value) {
    if (this.isEmpty()) {
      return 0;
    } else {
      int count = 0;
      Node current = this.last.getNext();
      do {
        if (current.hasValue(value)) {
          count++;
        }
        current = current.getNext();
      } while (current != this.last.getNext());
      return count;
    }
  }

  public void addLast(int value) {
    if (this.isEmpty()) {
      this.last = new Node(value, null);
      this.last.setNext(this.last);
    } else {
      Node newNode = new Node(value, this.last.getNext());
      this.last.setNext(newNode);
      this.last = newNode;
    }
    numOfValues++;
  }

  public void removeFirst() {
    if (this.isEmpty()) {
      throw new NullPointerException("La lista esta vacia");
    } else {
      if (numOfValues == 1) {
        this.last = null;
      } else {
        this.last.setNext(this.last.getNext().getNext());
      }
      numOfValues--;
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node current = this.last.getNext();
    for (int i = 0; i < numOfValues; i++) {
      sb.append("\n" + "Posicion: " + (i + 1) + ": " + current.getValue());
      current = current.getNext();
    }
    return sb.toString();
  }
}
