
package es.uvigo.esei.aed1.activity2.circularDoublyLinked;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;
import es.uvigo.esei.aed1.commonLinked.Node;

public class CircularDoublyLinked {
  private DoubleNode last;
  private int numOfValues;

  public CircularDoublyLinked() {
    this.last = null;
    this.numOfValues = 0;
  }

  public boolean isEmpty() {
    return this.numOfValues == 0;
  }

  public int size() {
    return this.numOfValues;
  }

  public int numberOfOccurrences(int value) {
    if (this.isEmpty()) {
      return 0;
    } else {
      int count = 0;
      DoubleNode current = this.last;
      do {
        if (current.hasValue(value)) {
          count++;
        }
        current = current.getNext();
      } while (current != this.last);
      return count;
    }
  }

  public boolean contains(int value) {
    if (this.isEmpty()) {
      return false;
    } else if (this.last.hasValue(value)) {
      return true;
    } else {
      DoubleNode current = this.last.getNext();
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

  public int firstValue() {
    if (this.isEmpty()) {
      throw new NullPointerException("La lista está vacía");
    } else {
      return this.last.getNext().getValue();
    }
  }

  public void addLast(int value) {
    if (this.isEmpty()) {
      this.last = new DoubleNode(null, value, null);
      this.last.setNext(this.last);
      this.last.setPrevious(this.last);
    } else {
      DoubleNode newNode = new DoubleNode(this.last, value, this.last.getNext());
      this.last.getNext().setPrevious(newNode);
      this.last.setNext(newNode);
      this.last = newNode;
    }
    this.numOfValues++;
  }

  public void removeFirst() {
    if (this.isEmpty()) {
      throw new NullPointerException("La lista está vacía");
    } else if (numOfValues == 1) {
      this.last = null;
      numOfValues--;
    } else {
      DoubleNode newFirst = this.last.getNext().getNext();
      this.last.setNext(newFirst);
      newFirst.setPrevious(this.last);
      numOfValues--;
    }
  }

  public void remove(int value) {
    if (this.isEmpty()) {
      throw new NullPointerException("La lista está vacía");
    } else if (this.last.hasValue(value)) {
      this.last.getPrevious().setNext(this.last.getNext());
      this.last.getNext().setPrevious(this.last.getPrevious());
      this.last = this.last.getPrevious();
      numOfValues--;
    } else {
      DoubleNode prev = this.last;
      DoubleNode current = this.last.getNext();
      while (!current.hasValue(value) && current != this.last) {
        prev = prev.getNext();
        current = current.getNext();
      }
      if (current.hasValue(value)) {
        prev.setNext(current.getNext());
        current.getNext().setPrevious(prev);
        numOfValues--;
      } else {
        System.out.println("No existe ningún nodo que contenga el valor dado");
      }
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    DoubleNode current = this.last.getNext();
    for (int i = 0; i < numOfValues; i++) {
      sb.append("\n"+"Posición: " + (i+1) + ": " + current.getValue());
      current = current.getNext();
    }
    return sb.toString();
  }
}
