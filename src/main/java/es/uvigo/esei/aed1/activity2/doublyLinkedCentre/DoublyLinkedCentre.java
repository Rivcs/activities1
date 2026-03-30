
package es.uvigo.esei.aed1.activity2.doublyLinkedCentre;

import es.uvigo.esei.aed1.commonLinked.DoubleNode;
import es.uvigo.esei.aed1.commonLinked.Node;

public class DoublyLinkedCentre {
  private DoubleNode mid;
  private int numOfValuesTotal;
  private int numOfValuesMinor;
  private int numOfValuesMajor;

  public DoublyLinkedCentre() {
    this.mid = null;
    this.numOfValuesTotal = 0;
    this.numOfValuesMinor = 0;
    this.numOfValuesMajor = 0;
  }

  public boolean isEmpty() {
    return numOfValuesTotal == 0;
  }

  public int size() {
    return numOfValuesTotal;
  }

  public boolean contains(int value) {
    if (this.isEmpty()) {
      return false;
    } else if (this.mid.hasValue(value)) {
      return true;
    }
    DoubleNode minor = this.mid.getPrevious();
    while (minor != null && !minor.hasValue(value)) {
      minor = minor.getPrevious();
    }
    if (minor == null) {
      return false;
    }
    if (minor.hasValue(value)) {
      return true;
    } else {
      DoubleNode major = this.mid.getNext();
      while (major != null && !major.hasValue(value)) {
        major = major.getNext();
      }
      if (major == null) {
        return false;
      }
      if (major.hasValue(value)) {
        return true;
      } else {
        return false;
      }
    }
  }

  public void add(int value) {
    if (this.isEmpty()) {
      this.mid = new DoubleNode(null, value, null);
      return;
    }
    // Valor igual al nodo central
    if (value == this.mid.getValue()) {
      DoubleNode newNode = new DoubleNode(mid, value, mid.getNext());
      this.mid.setNext(newNode);
      this.mid.getNext().setPrevious(newNode);
      numOfValuesMajor++;
      numOfValuesTotal++;
      return;
    } else if (value < this.mid.getValue()) { // Valor menor al nodo central
      DoubleNode minor = this.mid.getPrevious();
      while (minor.getPrevious() != null && value < minor.getValue()) {
        minor = minor.getPrevious();
      }
      // El nuevo nodo es el primero de la lista
      if (minor.getPrevious() == null && value <= minor.getPrevious().getValue()) {
        DoubleNode newNodeMinor = new DoubleNode(null, value, minor.getPrevious());
        minor.getPrevious().setPrevious(newNodeMinor);
      } else { // El nuevo nodo no es el menor de la lista
        DoubleNode newNodeMinor = new DoubleNode(minor.getPrevious(), value, minor);
        minor.getPrevious().setNext(newNodeMinor);
        minor.setPrevious(newNodeMinor);
      }
      numOfValuesMinor++;
      numOfValuesTotal++;
      return;
    } else if (value > this.mid.getValue()) {
      DoubleNode major = this.mid.getNext();
      while (major.getNext() != null && value > major.getValue()) {
        major = major.getNext();
      }
      // El nuevo nodo es el mayor de la lista
      if (major.getNext() == null && major.getNext().getValue() < value) {
        DoubleNode newNodeMajor = new DoubleNode(major.getNext(), value, null);
        major.getNext().setNext(newNodeMajor);
      } else { // El nuevo nodo no es el mayor de la lista
        DoubleNode newNodeMajor = new DoubleNode(major, value, major.getNext());
        major.setNext(newNodeMajor);
        major.getNext().setPrevious(newNodeMajor);
      }
      numOfValuesMajor++;
      numOfValuesTotal++;
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < numOfValuesTotal; i++) {
      sb.append("\n" + "Nodo" + (i + 1));
    }
    return sb.toString();
  }

}
