package es.uvigo.esei.aed1.activity9.implementation;

import es.uvigo.esei.aed1.tads.list.LinkedList;
import es.uvigo.esei.aed1.tads.list.List;

public class DinamicHashTable<T> implements HashTable<T> {

    private int numElem;
    private List<T>[] data;

    @SuppressWarnings("unchecked")
    public DinamicHashTable(int capacity) throws IllegalArgumentException {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        } else {
            numElem = 0;
            data = new List[capacity];
            for (int i = 0; i < capacity; i++) {
                data[i] = new LinkedList<>();
            }
        }
    }

    public DinamicHashTable() {
        this(50);
        numElem = 0;
    }

    private int functionHash(T key) {
        return Math.abs(key.hashCode()) % data.length;
    }

    @Override
    public boolean add(T elem) {
        int posicion = functionHash(elem);
        if (data[posicion].contains(elem)) {
            return false;
        } else {
            data[posicion].addFirst(elem);
            numElem++;
            return true;
        }
    }

    @Override
    public boolean search(T elem) {
        int posicion = functionHash(elem);
        if (!data[posicion].contains(elem)) {
            return false;
        } else {
            data[posicion].removeValue(elem);
            data[posicion].addFirst(elem);
            return true;
        }
    }

    @Override
    public boolean remove(T elem) {
        int posicion = functionHash(elem);
        if (!data[posicion].contains(elem)) {
            return false;
        } else {
            data[posicion].removeValue(elem);
            numElem--;
            return true;
        }
    }

    @Override
    public int size() {
        return numElem;
    }

    @Override
    public T get() {
        for (List<T> list : data) {
            if (!list.isEmpty()) {
                return list.getFirst();
            }
        }
        return null;
    }

}
