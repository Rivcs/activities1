
package es.uvigo.esei.aed1.activity6;

import es.uvigo.esei.aed1.activity6.implementation.CustomQueue;
import es.uvigo.esei.aed1.tads.queue.LinkedQueue;
import es.uvigo.esei.aed1.tads.queue.Queue;

public class Activity6 {

    // Exercise 1.1
    public static <T> void concat(Queue<T> queue1, Queue<T> queue2) throws NullPointerException {
        if (queue1 == null || queue2 == null) {
            throw new NullPointerException("Las colas no pueden estar vacias");
        }
        while (!queue2.isEmpty()) {
            queue1.add(queue2.remove());
        }
    }

    // Exercise 1.2
    public static <T> Queue<T> mix(Queue<T> queue1, Queue<T> queue2) throws NullPointerException {
        if (queue1 == null || queue2 == null) {
            throw new NullPointerException("Las colas no pueden estar vacias");
        }
        Queue<T> queue3 = new LinkedQueue<>();
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            queue3.add(queue2.remove());
            queue3.add(queue1.remove());
        }
        return queue3;
    }

    // Exercise 2
    public static <T> Queue<T> copy(Queue<T> queue) throws NullPointerException {
        return null;
    }

    // Exercise 3
    public static Queue<Integer> mixInOrderly(Queue<Integer> queue1, Queue<Integer> queue2)
            throws NullPointerException {
        return null;
    }

    // Exercise 4
    public static <T> void moveToFront(Queue<T> queue, T value) throws NullPointerException {

    }

    // Exercise 5
    public static Integer josephus(Queue<Integer> soldiers, int initialPos, int jump) {
        return 0;
    }

    // Ejercicio 6
    public static <T> boolean equalsValues(CustomQueue<T> queue) throws NullPointerException {
        return true;
    }

}
