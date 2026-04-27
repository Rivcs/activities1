
package es.uvigo.esei.aed1.activity5;

import es.uvigo.esei.aed1.activity6.implementation.EmptyException;
import es.uvigo.esei.aed1.tads.stack.LinkedStack;
import es.uvigo.esei.aed1.tads.stack.Stack;

public class Activity5 {

  // Exercise 1
  public static String reverseWords(String text) {
    return null;
  }

  // Exercise 2 i
  public static <T> boolean equalStacks(Stack<T> stack1, Stack<T> stack2) throws NullPointerException {
    if (stack1 == null || stack2 == null) {
      throw new NullPointerException("Alguno de los stacks es null");
    }
    if (stack1.size() != stack2.size()) {
      return false;

    }
    while (!stack1.isEmpty() && !stack2.isEmpty()) {
      if (stack1.top().equals(stack2.top())) {
        stack1.pop();
        stack2.pop();
      } else {
        return false;
      }
    }
    return true;
  }

  // Exercise 2 ii
  public static <T> Stack<T> copy(Stack<T> stack) throws NullPointerException {
    if (stack == null) {
      throw new NullPointerException("La pila está vacía, no se puede copiar");
    }
    Stack<T> auxStack = new LinkedStack<>();
    Stack<T> copy = new LinkedStack<>();
    while (!stack.isEmpty()) {
      auxStack.push(stack.pop());
    }
    while (!auxStack.isEmpty()) {
      stack.push(auxStack.top());
      copy.push(auxStack.pop());
    }
    return copy;
  }

  // Exercise 3
  public static String fromBase10ToBase2(int numberBase10) {
    return null;
  }

  // Exercise 4
  public static int getNumDiamonds(String sand) {
    if (sand.isBlank()) {
      throw new EmptyException("El string esta vacío");
    }
    Stack<Character> stack = new LinkedStack<>();
    int contador = 0;
    for (int i = 0; i < sand.length(); i++) {
      if (sand.charAt(i) == '<') {
        stack.push(sand.charAt(i));
      } else if (!stack.isEmpty() && sand.charAt(i) == '>') {
        contador++;
        stack.pop();
      }
    }
    return contador;
  }

  // Exercise 5
  public static String codifyMessage(String message) {
    return null;
  }

  // Exercise 6
  public static <T> T unstackAnItem(Stack<T> stack, int index) throws NullPointerException, IllegalArgumentException {

    return null;
  }

  // Exercice 7

  public static boolean isWellParentized(String mathExpression) {
    if (mathExpression.isBlank()) {
      return false;
    }
    Stack<Character> verifyStack = new LinkedStack<>();
    for (int i = 0; i < mathExpression.length(); i++) {
      if (mathExpression.charAt(i) == '{') {
        verifyStack.push(mathExpression.charAt(i));
      }
      if (mathExpression.charAt(i) == '[') {
        verifyStack.push(mathExpression.charAt(i));
      }
      if (mathExpression.charAt(i) == '(') {
        verifyStack.push(mathExpression.charAt(i));
      }
      if (mathExpression.charAt(i) == '}' && verifyStack.pop() != '{') {
        return false;
      }
      if (mathExpression.charAt(i) == ']' && verifyStack.pop() != '[') {
        return false;
      }
      if (mathExpression.charAt(i) == ')' && verifyStack.pop() != '(') {
        return false;
      }
    }
    return true;
  }

  // Exercise 8
  public static String addDigits(int number) {
    return null;
  }

  // Exercise 9
  public static String removeCharDuplicated(String text) {
    return null;
  }

  // Exercise 10
  public static <T> void replaceValues(Stack<T> stack, T newValue, T oldValue) throws NullPointerException {

  }

  // Exercise 11
  public static <T> void pushValuesLimited(Stack<T> stack, T value) throws NullPointerException {

  }

}
