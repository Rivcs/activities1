package ejerciciosTADSExamen.ejercicio3;

public class DoubleNode<T> {
    private DoubleNode<T> previous;
    private T value;
    private DoubleNode<T> next;

    public DoubleNode(DoubleNode<T> previous, T value, DoubleNode<T> next) {
        this.previous = previous;
        this.value = value;
        this.next = next;
    }

    public DoubleNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DoubleNode<T> getNext() {
        return next;
    }

    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }
}
