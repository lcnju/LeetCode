// Implement the following operations of a queue using stacks.

// push(x) -- Push element x to the back of queue.
// pop() -- Removes the element from in front of queue.
// peek() -- Get the front element.
// empty() -- Return whether the queue is empty.
// Notes:
// You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty operations are valid.
// Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (double-ended queue), as long as you use only standard operations of a stack.
// You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

class MyQueue {
	private Stack<Integer> stack1 = new Stack<>();
	private Stack<Integer> stack2 = new Stack<>();

	// Push element x to the back of queue.
	public void push(int x) {
		stack1.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		exchange(stack1, stack2);
		stack2.pop();
		exchange(stack2, stack1);
	}

	// Get the front element.
	public int peek() {
		exchange(stack1, stack2);
		int answer = stack2.peek();
		exchange(stack2, stack1);
		return answer;
	}

		
	// Return whether the queue is empty.
	public boolean empty() {
		return stack1.empty();
	}

	private void exchange(Stack<Integer> a, Stack<Integer> b) {
		b.clear();
		while (!a.empty()) {
			b.push(a.pop());
		}
	}
}