
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StrStackTest {
	StrStack testStack;
	String str1 = "hello";
	String str2 = "world";

	@BeforeEach
	void successfulStack() {
		testStack = new StrStack();
	}
	
	@Test
	void sizeTest() {
		assertEquals(testStack.size(), 0,
				"SizeTest: Tests if new stack is empty");
	}
	
	@Test
	void pushTest() {
		testStack.push(str1);
		assertEquals(testStack.size(), 1,
				"Successful push: size() = 1");
	}
	
	@Test
	void popEmptyStackTest() {
		assertThrows(EmptyStackException.class, () -> testStack.pop(),
				"Empty Stack: nothing to pop");
	}

	@Test
	void pushPopTest() throws Exception {
		testStack.push(str1);
		assertEquals(testStack.pop(), str1,
				"PushPopTest: pop() after push() = 'hello'");
	}
	
	@Test
	void pushPopPopTest() throws Exception { //Test 5
		testStack.push(str1);
		testStack.pop();
		assertThrows(EmptyStackException.class, () -> testStack.pop(),
				"Empty Stack: nothing to pop");
	}
	
	@Test
	void pushPushPopTest() throws Exception { //Test 6
		testStack.push(str1);
		testStack.push(str2);
		assertEquals(testStack.pop(), str2, 
				"PushPushPopTest: pop() after push() twice = 'world'");
	}
	@Test
	void topEmptyStack() {
		assertThrows(EmptyStackException.class, () -> testStack.top(),
				"Empty Stack: no contents to perform top()");
	}
	
	@Test
	void pushTopTest() throws Exception {
		testStack.push(str1);;
		assertEquals(testStack.top(), str1,
				"PushTopTest: top() after push() = 'hello'");
	}
	
	@Test
	void pushPushTopTest() throws Exception { //Test 9
		testStack.push(str1);
		testStack.push(str2);
		assertEquals(testStack.top(), str2,
				"PushPushTopTest: top() after push() twice = 'world'");
	}
	
	@Test
	void popTopTest() throws Exception {
		testStack.push(str1);
		testStack.pop();
		assertThrows(EmptyStackException.class, () -> testStack.top(),
				"Empty Stack: no contents to perform top()");
	}
	
	@Test
	void popPopTopTest() throws Exception { //Test 11
		testStack.push(str1);
		testStack.push(str2);
		assertEquals(testStack.top(), str2);
		testStack.pop();
		assertEquals(testStack.top(), str1, 
				"Pop1TopTest: top() after pop() = 'hello'");
		testStack.pop();
		assertThrows(EmptyStackException.class, () -> testStack.top(),
				"Empty Stack: no contents to perform top()");
	}
}
