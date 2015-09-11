package calculateII;

import java.util.*;

// including parenthesis
// reference: https://leetcode.com/discuss/39454/accepted-infix-postfix-based-solution-explaination-600ms

public class Solution {
	public int calculate(String s) {
		return evaluatePostfix(infixToPostfix(s));
	}

	private int evaluatePostfix(List<Object> postfix) {
		Stack<Integer> operands = new Stack<Integer>();
		int a = 0, b = 0;

		for (Object s : postfix) {
			if (s instanceof Character) {
				char c = (Character) s;
				b = operands.pop();
				a = operands.pop();
				switch (c) {
				case '+':
					operands.push(a + b);
					break;
				case '-':
					operands.push(a - b);
					break;
				case '*':
					operands.push(a * b);
					break;
				case '/':
					operands.push(a / b);
					break;
				default:
					break;
				}
			} else {
				operands.push((Integer) s);
			}
		}
		return operands.pop();
	}

	private List<Object> infixToPostfix(String s) {
		Stack<Character> operators = new Stack<Character>();
		List<Object> postfix = new LinkedList<Object>();

		int num = 0;
		boolean isOperand = false;
		for (char c : s.toCharArray()) {
			if (c >= '0' && c <= '9') {
				num = num * 10 + c - '0';
				isOperand = true;
			} else {
				if (isOperand)
					postfix.add(num);
				num = 0;
				isOperand = false;

				if (c == ' ' || c == '\t')
					continue;

				if (c == '(') {
					operators.push('(');
				} else if (c == ')') {
					while (operators.peek() != '(') {
						postfix.add(operators.pop());
					}
					operators.pop(); // pop "(";
				} else {
					while (!operators.isEmpty()
							&& rank(c) <= rank(operators.peek())) {
						postfix.add(operators.pop());
					}
					operators.push(c);
				}
			}
		}

		if (isOperand) {
			postfix.add(num);
		}

		while (!operators.isEmpty()) {
			postfix.add(operators.pop());
		}
		return postfix;
	}

	private int rank(char op) {
		switch (op) {
		case '+':
			return 1;
		case '-':
			return 1;
		case '*':
			return 2;
		case '/':
			return 2;
		default:
			return 0;
		}
	}
}
