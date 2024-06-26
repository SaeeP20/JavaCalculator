
import java.util.ArrayList;
import java.util.List;

/**
 * Class implementing a simple stack data structure using an ArrayList.
 * The class represents a LIFO (last-in, first-out) stack where elements are pushed onto the top
 * of the stack and popped from the top.
 * The stack accepts elements of type {@link Entry}.
 *
 * @author Saee Pujari
 */
public class Stack {

  private List<Entry> stackList = new ArrayList<Entry>();
  private int stackSize = 0;
  private Entry topEntry = null;

  /**
   * Returns the size of the stack.
   *
   * @return The size of the stack.
   */
  public int size() {
    return stackSize;
  }

  /**
   * Adds an element to the top of the stack. Increases the size of the stack by 1.
   *
   * @param n The {@link Entry} element to be pushed onto the stack.
   */
  public void push(Entry n) {
    stackList.add(n);
    stackSize++;
  }

  /**
   * Removes and returns the element at the top of the stack.
   *
   * @return The popped element.
   * @throws EmptyStackException if the stack is empty.
   */
  public Entry pop() throws EmptyStackException {
    if (size() == 0) {
      throw new EmptyStackException();
    }
    Entry poppedEntry = stackList.remove(size() - 1);
    stackSize--;
    return poppedEntry;
  }

  /**
   * Returns the element at the top of the stack without performing other actions.
   *
   * @return The element at the top of the stack.
   * @throws EmptyStackException if the stack is empty.
   */
  public Entry top() throws EmptyStackException {
    if (size() == 0) {
      throw new EmptyStackException();
    }
    topEntry = stackList.get(size() - 1);
    return topEntry;
  }
}