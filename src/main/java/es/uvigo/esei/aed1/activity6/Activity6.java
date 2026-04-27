
package es.uvigo.esei.aed1.activity6;

import es.uvigo.esei.aed1.activity6.implementation.CustomQueue;
import es.uvigo.esei.aed1.activity6.implementation.LinkedQueue2Ref;
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
        if (queue == null) {
            throw new NullPointerException();
        }
        Queue<T> tempQueue = new LinkedQueue<>();
        Queue<T> copyQueue = new LinkedQueue<>();

        // Vaciamos la original en una temporal
        while (!queue.isEmpty()) {
            tempQueue.add(queue.remove());
        }

        // Volvemos a llenar la original y la copia
        while (!tempQueue.isEmpty()) {
            T value = tempQueue.remove();
            queue.add(value);
            copyQueue.add(value);
        }

        return copyQueue;
    }

    // Exercise 3
    public static Queue<Integer> mixInOrderly(Queue<Integer> queue1, Queue<Integer> queue2)
            throws NullPointerException {
        if (queue1 == null || queue2 == null) {
            throw new NullPointerException();
        }

        Queue<Integer> queuemixed = new LinkedQueue<>();
        int sizeQueue1 = queue1.size();
        int sizeQueue2 = queue2.size();
        int processedQueue1 = 0;
        int processedQueue2 = 0;

        while (processedQueue1 < sizeQueue1 || processedQueue2 < sizeQueue2) {
            boolean takeValueQueue1 = processedQueue1 < sizeQueue1;
            boolean takeValueQueue2 = processedQueue2 < sizeQueue2;

            // Si ambas tienen elementos por procesar, decidimos de cuál coger
            if (takeValueQueue1 && takeValueQueue2) {
                if (queue1.first() < queue2.first()) { // Si el primero de la cola 1 es menor que el primero de la cola
                                                       // 2
                    takeValueQueue2 = false;
                } else if (queue2.first() < queue1.first()) { // Si el primero de la cola 2 es menor que el primero de
                                                              // la cola 1
                    takeValueQueue1 = false;
                }
                // Si son iguales, ambos `take` se quedan en true para avanzar las dos a la vez
            }

            Integer smaller = takeValueQueue1 ? queue1.first() : queue2.first();

            // Insertamos directamente el número que hemos elegido
            queuemixed.add(smaller);

            // Aplicamos la rotación
            if (takeValueQueue1) {
                queue1.add(queue1.remove());
                processedQueue1++;
            }
            if (takeValueQueue2) {
                queue2.add(queue2.remove());
                processedQueue2++;
            }
        }
        return queuemixed;
    }

    // Exercise 4
    public static <T> void moveToFront(Queue<T> queue, T value) throws NullPointerException { // Copiar cola sin el
                                                                                              // valor y añadirlo al
                                                                                              // final
        if (queue == null) {
            throw new NullPointerException();
        }
        Queue<T> copyQueueNoValue = new LinkedQueue<>();

        while (!queue.isEmpty()) {
            T auxValue = queue.remove();

            if (!auxValue.equals(value)) {
                copyQueueNoValue.add(auxValue);
            }
        }
        queue.add(value);
        while (!copyQueueNoValue.isEmpty()) {
            queue.add(copyQueueNoValue.remove());
        }
    }

    // Exercise 5
    public static Integer josephus(Queue<Integer> soldiers, int initialPos, int jump) {
        while (soldiers.size() != 1) {
            for (int i = 0; i < jump; i++) {
                soldiers.add(soldiers.remove());
            }
        }
        return 0;
    }

    // Ejercicio 6
    public static <T> boolean equalsValues(CustomQueue<T> queue) throws NullPointerException {
        if (queue == null) {
            throw new NullPointerException("La cola está vacía");
        }
        if (queue.isEmpty()) {
            return true;
        }
        boolean equal = true;
        CustomQueue<T> backupQueue = new LinkedQueue2Ref<>();
        T value = queue.remove();
        backupQueue.add(value);
        while (!queue.isEmpty()) {
            T removeNext = queue.remove();
            backupQueue.add(removeNext);
            if (!value.equals(removeNext)) {
                equal = false;
            }
        }
        for (int i = 0; i < backupQueue.size(); i++) {
            queue.add(backupQueue.remove());
        }
        return equal;
    }
}
