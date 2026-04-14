package es.uvigo.esei.aed1.activity8;

public class SearchAlgorithms {

    // Exercise 1
    public static void fillIn(int[][] aux, int xPosition, int yPosition, int newColor)
            throws IndexOutOfBoundsException {

         // Verificar que las posiciones x,y estén dentro de los límites del tablero
        if (xPosition < 0 || xPosition >= aux.length || yPosition < 0 || yPosition >= aux[0].length) {
            throw new IndexOutOfBoundsException("Las posiciones x,y deben estar dentro de los límites del tablero.");
        }


    }

    // Exercise 2
    public static boolean isMagicSquare(int[][] board, int magicConstant) {

        return true;

    }

    // Exercise 3
    public static int howManyMinors(int[] aux, int elem) {

        return -1;
    }

    // Exercise 4
    public static int howManyOlder(int[] aux, int elem) {

        return -1;
    }

    // Exercise 5
    public static int containNumber(int[] array, int beginning, int fin) {
        return -1;
    }

    // Exercise 6
    public static int searchInsertionDec(int[] aux, int elem, int max) {
        return -1;

    }

}
