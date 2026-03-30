package es.uvigo.esei.aed1.activity3.orderedByValueLinkedDummy;

public class OrderedByValueLinkedDummy {
  private NodePair dummy;
  private int numberOfValues;

  public OrderedByValueLinkedDummy() {
    this.dummy = new NodePair(null, null);
    this.numberOfValues = 0;
  }

  // Algoritmo de búsqueda sobre una estructura enlazada ordenada
  public boolean contains(int value) {
    NodePair current = this.dummy.getNext();
    while (current != null && current.getPair().getValue() < value) {
      current.getNext();
    }
    if (current == null || current.getPair().getValue() > value) {
      System.out.println("El valor no está en la estructura enlazada");
      return false;
    }
    return true;
  }

  public void add(int value) {
    NodePair current = this.dummy;
    while (current.getNext() != null && current.getNext().getPair().getValue() < value) {
      current = current.getNext();
    }
    if (current.getNext() == null || current.getNext().getPair().getValue() > value) {
      NodePair newNode = new NodePair(new Pair(1, value), current.getNext());
      current.setNext(newNode);
    } else {
      // Value ya está en la estructura. Solo tenemos que incrementar el contador.
      Pair par = current.getNext().getPair();
      par.setCounter(par.getCounter() + 1);
    }
    this.numberOfValues++;
  }

  public void remove(int value) {
    NodePair current = this.dummy;
    while (current.getNext() != null && current.getNext().getPair().getValue() < value) {
      current = current.getNext();
    }
    if (current.getNext() == null || current.getNext().getPair().getValue() > value) {
      System.out.println("El valor para eliminar no fue encontrado");
    } else {
      Pair par = current.getNext().getPair();
      if (par.getCounter() == 1) {
        current.setNext(current.getNext().getNext());
      } else {
        par.setCounter(par.getCounter() - 1);
      }
      this.numberOfValues--;
    }
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (NodePair current = this.dummy.getNext(); current != null; current.getNext()) {
      sb.append(current.getPair());
    }
    return sb.toString();
  }
}
