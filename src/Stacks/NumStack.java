
/**
 * Class implementing an instance of {@link Stack}. The methods are designed to return the Float
 * value for every {@link Entry} in the stack.
 * 
 * @author Saee Pujari
 */
public class NumStack {
  private Stack baseStack = new Stack();

  /**
   * Returns the size of the stack.
   * 
   * @return The size of the stack.
   */
  public int size() {
    return baseStack.size(); // Calls method from Stack as there are no changes to be made
  }

  /**
   * Adds Entry(float) element to the top of stack, increases size by 1.
   * 
   * @param n The float argument used to initialise a new {@link Entry}.
   */
  public void push(Float n) {
    Entry newPush = new Entry(n); // Stack only accepts elements of type Entry
    baseStack.push(newPush);
  }

  /**
   * Removes and returns the float value of the element at the top of the stack.
   * 
   * @return The float value of the popped element.
   * @throws Exception if stack is empty or element is the incorrect type.
   */
  public Float pop() throws Exception { // Handles all the custom exceptions thrown
    if (baseStack.size() == 0) {
      throw new EmptyStackException();
    }
    return baseStack.pop().getValue();
  }

  /**
   * Returns the float value of the element at the top of the stack.
   * 
   * @return The float value of the top element.
   * @throws Exception if stack is empty or element is the incorrect type.
   */
  public Float top() throws Exception {
    if (size() == 0) {
      throw new EmptyStackException();
    }
    return baseStack.top().getValue();
  }
}
