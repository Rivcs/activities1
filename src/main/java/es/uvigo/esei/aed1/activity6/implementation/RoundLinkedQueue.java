
package es.uvigo.esei.aed1.activity6.implementation;

import static java.util.Objects.requireNonNull;

public class RoundLinkedQueue<T> implements CustomQueue<T> {
  private Node<T> last;
  private int numOfElements;

  public RoundLinkedQueue() {
    this.last = null;
    numOfElements = 0;
  }

  @Override
  public boolean isEmpty() {
    return numOfElements == 0;
  }

  @Override
  public int size() {
    return numOfElements;
  }

  @Override
  public T first() throws EmptyException {
    if (this.isEmpty()) {
      throw new EmptyException("La cola está vacía");
    }
    return this.last.getNext().getValue();
  }

  @Override
  public void add(T value) throws NullPointerException {
    if (value == null) {
      throw new NullPointerException("El valor no puede ser nulo");
    }
    if (this.isEmpty()) {
      this.last = new Node<T>(value, last);
    } else {
      Node<T> newNode = new Node<T>(value, last.getNext());
      this.last.setNext(newNode);
    }
    numOfElements++;
  }

  @Override
  public T remove() throws EmptyException {
    if (this.isEmpty()) {
      throw new EmptyException();
    }
    T value = this.last.getNext().getValue();
    if (numOfElements == 1) {
      this.last = null;
    } else {
      this.last.setNext(this.last.getNext().getNext());
    }
    numOfElements--;
    return value;
  }

  @Override
  public void clear() {
    this.last = null;
    numOfElements = 0;
  }
}
