
public class StrStack {
	private Stack baseStack = new Stack();

	public int size() {
		return baseStack.size();
	}

	public void push(String str) {
		Entry newPush = new Entry(str);
		baseStack.push(newPush);
	}

	public String pop() throws Exception {
		if (size() == 0) {
			throw new EmptyStackException();
		}
		return baseStack.pop().getInput();
	}

	public String top() throws Exception {
		if (size() == 0) {
			throw new EmptyStackException();
		}
		return baseStack.top().getInput();
	}


}
