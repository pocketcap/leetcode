class Stack {
public:
// Push element x onto stack.
	void push(int x) {
		int size = s.size();
		this->s.push(x);
		while (size--) {
			s.push(s.front());
			s.pop();
		}
	}

// Removes the element on top of the stack.
	void pop() {
		s.pop();
	}

// Get the top element.
	int top() {
		return s.front();
	}

// Return whether the stack is empty.
	bool empty() {
		return s.empty();
	}
private:
	queue<int> s;
};
