
package es.uvigo.esei.aed1.activity6.implementation;

import static java.util.Objects.requireNonNull;

public class LinkedQueue2Ref<T> implements CustomQueue<T> {
  private Node<T> first;
  private Node<T> last;
  private int numOfElements;

  public LinkedQueue2Ref() {
    this.first = null;
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
      throw new EmptyException("La lista está vacía");
    }
    return this.first.getValue();
  }

  @Override
  public void add(T value) throws NullPointerException {
    if (value == null) {
      throw new NullPointerException("El nuevo valor no puede ser nulo");
    }
    Node<T> newNode = new Node<T>(value, null);
    if (this.isEmpty()) {
      this.first = newNode;
      this.last = newNode;
    } else {
      this.last.setNext(newNode);
      this.last = newNode;
      this.numOfElements++;
    }
  }

  @Override
  public T remove() throws EmptyException {
    if (this.isEmpty()) {
      throw new EmptyException("La lista está vacía, no se puede borrar");
    }
    T valueFirst = this.first.getValue();
    if (numOfElements == 1) {
      this.first = null;
      this.last = null;
    } else {
      this.first = this.first.getNext();
    }
    numOfElements--;
    return valueFirst;
  }

  @Override
  public void clear() {
    this.first = null;
    this.last = null;
    this.numOfElements = 0;
  }

}
