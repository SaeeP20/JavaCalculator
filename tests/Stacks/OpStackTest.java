
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OptestStack {
	private OpStack testStack;
	private Symbol sym1 = Symbol.DIVIDE;
	private Symbol sym2 = Symbol.PLUS;

	@BeforeEach
	void successfulStack() {
		testStack = new OpStack();
	}

	@Test
	void sizeTest() { //Test 1
		assertEquals(testStack.size(), 0,
				"SizeTest: tests if size of new stack is 0");
	}
	
	@Test
	void pushTest() { //Test 2
		testStack.push(sym1);
		assertEquals(testStack.size(), 1,
				"Successful Push: size() = 1");
	}
	
	@Test
	void popEmptytestStack() { //Test 3
		assertThrows(EmptyStackException.class, () -> testStack.pop(),
				"Empty Stack: nothing to pop");
	}
	
	@Test
	void pushPopTest() throws Exception { //Test 4
		testStack.push(sym1);
		assertEquals(testStack.pop(), sym1, 
				"PushPop: pop() after push() = sym1");
	}
	
	@Test
	void pushPopPopTest() throws Exception { //Test 5
		testStack.push(sym1);
		testStack.pop();
		assertThrows(EmptyStackException.class, () -> testStack.pop(),
				"Empty Stack: nothing to pop");
	}
	
	@Test
	void topEmptytestStack() { //Test 6
		assertThrows(EmptyStackException.class, () -> testStack.top(),
				"Empty Stack: no contents to perform top()");
	}
	
	@Test
	void pushPushPopTest() throws Exception { //Test 7
		testStack.push(sym1);
		testStack.push(sym2);
		assertEquals(testStack.pop(), sym2, 
				"PushPushPopTest: pop() after push() twice = Symbol.PLUS");
	}
	
	@Test
	void pushTopTest() throws Exception { //Test 8
		testStack.push(sym1);
		assertEquals(testStack.top(), sym1, 
				"PushTop: top() after push(sym1) = Symbol.DIVIDE");
	}
	
	@Test
	void pushPushTopTest() throws Exception { //Test 9
		testStack.push(sym1);
		testStack.push(sym2);
		assertEquals(testStack.top(), sym2,
				"PushPushTopTest: top() after push() twice = Symbol.PLUS");
	}
	
	@Test
	void popTopTest() throws Exception { //Test 10
		testStack.push(sym1);
		testStack.pop();
		assertThrows(EmptyStackException.class, () -> testStack.top(), 
				"Empty Stack: no contents to perform top()");
	}
	
	@Test
	void popPopTopTest() throws Exception { //Test 11
		testStack.push(sym1);
		testStack.push(sym2);
		assertEquals(testStack.top(), sym2,
				"TopTest: top of stack is Symbol.PLUS");
		testStack.pop();
		assertEquals(testStack.top(), sym1, 
				"Pop1TopTest: top() after pop() = Symbol.DIVIDE");
		testStack.pop();
		assertThrows(EmptyStackException.class, () -> testStack.top(),
				"Empty Stack: no contents to perform top()");
	}
	
}
