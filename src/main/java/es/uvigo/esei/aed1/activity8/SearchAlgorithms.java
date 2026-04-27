package es.uvigo.esei.aed1.activity8;

public class SearchAlgorithms {

    // Exercise 1
    public static void fillIn(int[][] aux, int xPosition, int yPosition, int newColor)
            throws IndexOutOfBoundsException {
        if (xPosition < 0 || xPosition >= aux.length || yPosition < 0 || yPosition >= aux[xPosition].length) {
            throw new IndexOutOfBoundsException();
        }

        int oldColor = aux[xPosition][yPosition];

        if (oldColor == newColor) {
            return;
        }

        aux[xPosition][yPosition] = newColor;

        // Hacer fillIn por la izquierda de xPosition, yPosition
        int col = yPosition - 1;
        while (col >= 0 && aux[xPosition][col] == oldColor) {
            aux[xPosition][col] = newColor;
            col--;
        }

        // Hacer fillIn por la derecha de xPosition, yPosition
        col = yPosition + 1;
        while (col < aux[xPosition].length && aux[xPosition][col] == oldColor) {
            aux[xPosition][col] = newColor;
            col++;
        }

        // Hacer fillIn por arriba de xPosition, yPosition
        int fil = xPosition - 1;
        while (fil >= 0 && yPosition < aux[fil].length && aux[fil][yPosition] == oldColor) {
            aux[fil][yPosition] = newColor;
            fil--;
        }

        // Hacer fillIn por debajo de xPosition, yPosition
        fil = xPosition + 1;
        while (fil < aux.length && yPosition < aux[fil].length && aux[fil][yPosition] == oldColor) {
            aux[fil][yPosition] = newColor;
            fil++;
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
