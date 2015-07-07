class Queue {
public:
	// Push element x to the back of queue.
	void push(int x) {
		while (!q.empty()) {
			s.push(q.top());
			q.pop();
		}
		s.push(x);
	}

	// Removes the element from in front of queue.
	void pop(void) {
		while (!s.empty()) {
			q.push(s.top());
			s.pop();
		}
		q.pop();
	}

	// Get the front element.
	int peek(void) {
		while (!s.empty()) {
			q.push(s.top());
			s.pop();
		}
		return q.top();
	}

	// Return whether the queue is empty.
	bool empty(void) {
		return s.empty() && q.empty();
	}
private:
	stack<int> s, q;
};
