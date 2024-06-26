
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class NumStackTest {
	private NumStack stackTest;
	private Float value1 = 8.0f;
	private Float value2 = 16.0f;
	
	@BeforeEach 
	void successfulStack() {
		stackTest = new NumStack();
	}
	
	@Test
	void sizeTest() { //Test 1
		assertEquals(stackTest.size(), 0, 
				"SizeTest: Tests if new stack is empty");
	}
	
	@Test
	void pushTest() { //Test 2
		stackTest.push(value1);
		assertEquals(stackTest.size(), 1, 
				"Successful push: size() = 1");
	}
	
	@Test 
	void popEmptyStackTest() { //Test 3
		assertThrows(EmptyStackException.class, () -> stackTest.pop(),
				"Empty Stack: nothing to pop");
	} //Created pop() method throwing EmptyStackException
	
	@Test
	void pushPopTest() throws EmptyStackException { //Test 4
		stackTest.push(value1);
		assertEquals(stackTest.pop(), value1, 
				"PushPopTest: pop() after push() = 8.0f");
	}
	
	@Test
	void pushPopPopTest() throws EmptyStackException { //Test 5
		stackTest.push(value1);
		stackTest.pop();
		assertThrows(EmptyStackException.class, () -> stackTest.pop(),
				"Empty Stack: nothing to pop");
	}
	
	@Test
	void pushPushPopTest() throws EmptyStackException { //Test 6
		stackTest.push(value1);
		stackTest.push(value2);
		assertEquals(stackTest.pop(), value2, 
				"PushPushPopTest: pop() after push() twice = 16.0f");
	}
	
	@Test
	void topEmptyStackTest() { //Test 7
		assertThrows(EmptyStackException.class, () -> stackTest.top(),
				"Empty Stack: no contents to perform top()");
	}
	
	@Test
	void pushTopTest() throws EmptyStackException { //Test 8
		stackTest.push(value1);
		assertEquals(stackTest.top(), value1, 
				"PushTopTest: top() after push() = 8.0f");
	}
	
	@Test
	void pushPushTopTest() throws EmptyStackException { //Test 9
		stackTest.push(value1);
		stackTest.push(value2);
		assertEquals(stackTest.top(), value2,
				"PushPushTopTest: top() after push() twice = 16.0f");
	}
	
	@Test
	void popTopTest() throws EmptyStackException { //Test 10
		stackTest.push(value1);
		stackTest.pop();
		assertThrows(EmptyStackException.class, () -> stackTest.top(), 
				"Empty Stack: no contents to perform top()");
	}
	
	@Test
	void popPopTopTest() throws EmptyStackException { //Test 11
		stackTest.push(value1);
		stackTest.push(value2);
		assertEquals(stackTest.top(), value2);
		stackTest.pop();
		assertEquals(stackTest.top(), value1, 
				"Pop1TopTest: top() after pop() = 8.0f");
		stackTest.pop();
		assertThrows(EmptyStackException.class, () -> stackTest.top(),
				"Empty Stack: no contents to perform top()");
	}
}
