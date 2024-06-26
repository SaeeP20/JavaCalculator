
public class OpStack {
	private Stack baseStack = new Stack();

	public int size() {
		return baseStack.size();
	}

	public void push(Symbol s) {
		Entry newPush = new Entry(s);
		baseStack.push(newPush);
	}

	public Symbol pop() throws Exception {
		if (size() == 0) {
			throw new EmptyStackException();
		}
		return baseStack.pop().getSign();
	}

	public Symbol top() throws Exception {
		if (size() == 0) {
			throw new EmptyStackException();
		}
		return baseStack.top().getSign();
	}
}
