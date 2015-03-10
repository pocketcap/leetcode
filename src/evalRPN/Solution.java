package evalRPN;

import java.util.*;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 */

public class Solution {
	public int evalRPN(String[] tokens) {
		int res = 0;
		String operations = "+-*/";

		Stack<String> stack = new Stack<String>();
		for (String t : tokens) {
			if (!operations.contains(t))
				stack.push(t);
			else {
				int a = Integer.parseInt(stack.pop());
				int b = Integer.parseInt(stack.pop());
				switch (t) {
				case "+":
					stack.push(String.valueOf(a + b));
					break;
				case "-":
					stack.push(String.valueOf(b - a));
					break;
				case "*":
					stack.push(String.valueOf(a * b));
					break;
				case "/":
					stack.push(String.valueOf(b / a));
					break;
				default:
					break;
				}
			}
		}
		res = Integer.parseInt(stack.pop());
		return res;
	}
}
