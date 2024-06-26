
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackTest {
  private Stack testStack;
  private Entry entry1 = new Entry(8.0f);
  private Entry entry2 = new Entry(Symbol.MINUS);

  @BeforeEach
  void successfulStack() { //Test 1 - Tests if a stack is successfully created
    testStack = new Stack();
  }

  @Test
  void testSize() { //Test 2 - Tests if stack is created as an empty stack
    assertEquals(testStack.size(), 0, "Size Test: to see if new stack is empty");
  } // Created size() method that returned 0

  @Test
  void testPush() { //Test 3 - Tests if Entry element is correctly added to stack
    testStack.push(entry1);
    assertEquals(testStack.size(), 1, "Push Test: to see if new stack has increased size");
  } // Created a push() method, taking in an entry argument and increasing size() by 1

  @Test
  void testEmptyStackPop() { //Test 4 - Tests if popping an empty stack throws exception
    assertThrows(uk.ac.rhul.cs.EmptyStackException.class, () -> testStack.pop(), 
        "Empty Stack: nothing to pop");
  } // Created a pop() method that throws EmptyStackException if stack size is 0
  
  @Test
  void testPushPop() throws uk.ac.rhul.cs.EmptyStackException {
    //Test 5 - Tests if element is popped correctly from non-empty stack
    testStack.push(entry1);
    assertEquals(testStack.pop(), entry1, "PushPop Test: pushing then popping should return 8.0f");
    assertEquals(testStack.size(), 0, "PostPop Size test: size should return 0 again");
    assertThrows(uk.ac.rhul.cs.EmptyStackException.class, () -> testStack.pop(), 
        "Empty Stack: nothing to pop");
  } // For size > 0, the element at top is removed using .remove() and returned. Size decreases by 1

  @Test
  void testPushPushPop() throws uk.ac.rhul.cs.EmptyStackException {
    //Test 6 - Further complex testing on pushing and popping elements
    testStack.push(entry1);
    testStack.push(entry2);
    assertEquals(testStack.pop(), entry2, "Push2Pop Test: popping after pushing returns MINUS");
    assertEquals(testStack.pop(), entry1, "Push1Pop Test: popping second time returns 8.0f");
    assertThrows(uk.ac.rhul.cs.EmptyStackException.class, () -> testStack.pop(), 
        "Empty Stack: nothing to pop");
  }

  @Test
  void testEmptyStackTop() { //Test 7 - Tests if using top() on empty stack throws an exception
    assertThrows(uk.ac.rhul.cs.EmptyStackException.class, () -> testStack.pop(), 
        "Empty Stack: stack is empty");
  } // Created a top() method throwing EmtpyStackException if stack size is 0

  @Test
  void testPushTop() throws uk.ac.rhul.cs.EmptyStackException {
    //Test 8 - Tests if top() correctly returns top element of non-empty stack
    testStack.push(entry1);
    assertEquals(testStack.top(), entry1, "PushTop Test: top of stack should be 8.0f");
  } // Created a variable and used .get() to equal it to top element of the stack and returned it

  @Test
  void testPopTop() throws uk.ac.rhul.cs.EmptyStackException {
    //Test 9 - Tests if top() correctly throws exception after a push-pop
    testStack.push(entry1);
    testStack.pop();
    assertThrows(uk.ac.rhul.cs.EmptyStackException.class, () -> testStack.pop(), 
        "Empty Stack: stack is empty");
  }

  @Test
  void testPushPushPopTop() throws uk.ac.rhul.cs.EmptyStackException {
    //Test 10 - Further complex testing on using top() after pushes-pops
    testStack.push(entry1);
    testStack.push(entry2);
    assertEquals(testStack.top(), entry2, "Push2Top Test: top of stack should return MINUS");
    testStack.pop();
    assertEquals(testStack.top(), entry1, "Push1Top Test: popping top of stack should return 8.0f");
    testStack.pop();
    assertThrows(uk.ac.rhul.cs.EmptyStackException.class, () -> testStack.top(), 
        "Empty Stack: stack is empty");
  }
}

