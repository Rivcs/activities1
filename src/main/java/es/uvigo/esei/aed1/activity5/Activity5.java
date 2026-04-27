
package es.uvigo.esei.aed1.activity5;

import es.uvigo.esei.aed1.activity6.implementation.EmptyException;
import es.uvigo.esei.aed1.tads.stack.LinkedStack;
import es.uvigo.esei.aed1.tads.stack.Stack;

public class Activity5 {

  // Exercise 1
  public static String reverseWords(String text) { // Invierte cada palabra de una frase
    Stack<Character> stack = new LinkedStack<>();
    StringBuilder resultadoString = new StringBuilder();
    for (int i = 0; i < text.length(); i++) {
      char letraActual = text.charAt(i);

      if (letraActual != ' ') {
        stack.push(text.charAt(i));
      } else {
        while (!stack.isEmpty()) {
          resultadoString.append(stack.pop());
        }

        resultadoString.append(letraActual);
      }
    }
    while (!stack.isEmpty()) {
      resultadoString.append(stack.pop());
    }
    return resultadoString.toString();
  }

  // Exercise 2 i
  public static <T> boolean equalStacks(Stack<T> stack1, Stack<T> stack2) throws NullPointerException {
    if (stack1 == null || stack2 == null) {
      throw new NullPointerException();
    }

    if (stack1.size() != stack2.size()) {
      return false;
    }
    Stack<T> stack1Copia = copy(stack1);
    Stack<T> stack2Copia = copy(stack2);

    while (!stack1Copia.isEmpty() && !stack2Copia.isEmpty()) {

      if (!stack1Copia.pop().equals(stack2Copia.pop())) {

        return false;
      }
    }
    return true;
  }

  // Exercise 2 ii
  public static <T> Stack<T> copy(Stack<T> stack) throws NullPointerException {

    if (stack == null) {
      throw new NullPointerException();
    }
    Stack<T> stackAux = new LinkedStack<>();
    Stack<T> stackCopy = new LinkedStack<>();

    while (!stack.isEmpty()) {
      stackAux.push(stack.pop());
    }
    while (!stackAux.isEmpty()) {
      stack.push(stackAux.top());
      stackCopy.push(stack.top());
      stackAux.pop();
    }
    return stackCopy;
  }

  // Exercise 3
  public static String fromBase10ToBase2(int numberBase10) {
    int numerator = numberBase10;
    int resto;
    StringBuilder resultadoString = new StringBuilder();
    Stack<Integer> stack = new LinkedStack<>();

    while (numerator > 0) {
      resto = numerator % 2;
      numerator = numerator / 2;
      stack.push(resto);
    }

    while (!stack.isEmpty()) {
      resultadoString.append(stack.pop());
    }

    return resultadoString.toString();
  }

  // Exercise 4
  public static int getNumDiamonds(String sand) {
    Stack<Character> stack = new LinkedStack<>();
    int numDiamonds = 0;
    for (int i = 0; i < sand.length(); i++) {

      if (sand.charAt(i) == '<') {
        stack.push(sand.charAt(i));
      }

      if (sand.charAt(i) == '>' && !stack.isEmpty()) {
        numDiamonds++;
        stack.pop();
      }

    }
    return numDiamonds;
  }

  // Exercise 5
  public static boolean VocalLetter(char c) {
    char min = Character.toLowerCase(c);
    if (min == 'a' || min == 'e' || min == 'i' || min == 'o' || min == 'u') {
      return true;
    } else {
      return false;
    }
  }

  public static String codifyMessage(String message) {
    Stack<Character> messageStack = new LinkedStack<>();
    StringBuilder resultadoString = new StringBuilder();
    for (int i = 0; i < message.length(); i++) {

      if (!VocalLetter(message.charAt(i))) {
        messageStack.push(message.charAt(i));
      } else {
        while (!messageStack.isEmpty()) {
          resultadoString.append(messageStack.pop());
        }
        resultadoString.append(message.charAt(i));
      }
    }
    while (!messageStack.isEmpty()) {
      resultadoString.append(messageStack.pop());
    }
    return resultadoString.toString();
  }

  // Exercise 6
  public static <T> T unstackAnItem(Stack<T> stack, int index) throws NullPointerException, IllegalArgumentException {
    if (stack.isEmpty()) {
      throw new IllegalArgumentException("La pila está vacía");
    }
    if (index < 1 || index >= stack.size()) {
      throw new IllegalArgumentException("No puedes eliminar un elemento que no está en la pila");
    }

    Stack<T> stackAux = new LinkedStack<>();
    T valueRemoved = null;
    int current = 1;

    while (!stack.isEmpty()) {
      if (current == index) {
        valueRemoved = stack.pop();
      } else {
        stackAux.push(stack.pop());
      }
      current++;
    }

    while (!stackAux.isEmpty()) {
      stack.push(stackAux.pop());
    }

    return valueRemoved;
  }

  // Exercice 7

  public static boolean isWellParentized(String mathExpression) {
    Stack<Character> stack = new LinkedStack<>();

    for (int i = 0; i < mathExpression.length(); i++) {
      char c = mathExpression.charAt(i);

      if (c == '(' || c == '[' || c == '{') {
        stack.push(c);
      } else if (c == ')' || c == ']' || c == '}') {
        if (stack.isEmpty()) {
          return false; // Si el string comienza con un parentesis de cierre está mal parentizado
        }

        if ((c == ')' && stack.top() == '(') ||
            (c == ']' && stack.top() == '[') ||
            (c == '}' && stack.top() == '{')) {
          stack.pop();
        } else {
          return false; // Si no coincide el signo de apertura con el de cerradura esta mal
                        // parentizado-> Ejemplo mal: (]
        }
      }
    }
    return stack.isEmpty(); // Si el stack esta vacío todos los parentesis, corchetes y llaves tienen cierre
                            // parejo->TRUE
  }

  // Exercise 8
  public static String addDigits(int number) {

    if (number == 0) {
      return "0 = 0";
    }

    number = Math.abs(number); // Por si pasan un número negativo

    Stack<Integer> stackAux = new LinkedStack<>();
    StringBuilder sb = new StringBuilder();
    int sumaResultado = 0;
    int digito;

    while (number > 0) {
      digito = number % 10;
      stackAux.push(digito);
      number = number / 10;
    }

    while (!stackAux.isEmpty()) {
      sb.append(stackAux.top());
      sumaResultado += stackAux.pop();
      if (!stackAux.isEmpty()) {
        sb.append(" + ");
      }
    }

    sb.append(" = ").append(sumaResultado);
    return sb.toString();
  }

  // Exercise 9

  public static String removeCharDuplicated(String text) {
    Stack<Character> stack = new LinkedStack<>();

    // Insertamos en orden inverso para que el TOP sea el primer carácter
    for (int i = text.length() - 1; i >= 0; i--) {
      stack.push(text.charAt(i));
    }

    return removeHelper(stack);
  }

  private static String removeHelper(Stack<Character> stack) {
    // Caso base: pila vacía → no quedan caracteres
    if (stack.isEmpty()) {
      return "";
    }

    char current = stack.pop(); // primer carácter a procesar
    String rest = removeHelper(stack); // resultado recursivo del resto

    // Si 'current' es igual al primer carácter de 'rest' → adyacente duplicado
    if (!rest.isEmpty() && rest.charAt(0) == current) {
      return rest; // descartamos current
    } else {
      return current + rest; // lo añadimos al frente
    }
  }

  // Exercise 10
  public static <T> void replaceValues(Stack<T> stack, T newValue, T oldValue) throws NullPointerException {
    
  }

  // Exercise 11
  public static <T> void pushValuesLimited(Stack<T> stack, T value) throws NullPointerException {

  }

}
