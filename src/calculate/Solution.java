package calculate;

import java.util.Stack;

public class Solution {
	public int calculate(String s) {
		Stack<Integer> signs = new Stack<Integer>(); // mark the sign before the
														// parenthesis
		signs.push(1);
		int sign = 1, result = 0, num = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c >= '0' && c <= '9') {
				num = num * 10 + c - '0';
			} else if (c == '+' || c == '-') {
				result = result + signs.peek() * sign * num;
				num = 0;
				sign = c == '+' ? 1 : -1;
			} else if (c == '(') {
				signs.push(signs.peek() * sign);
				sign = 1;
			} else if (c == ')') {
				result = result + signs.pop() * sign * num;
				sign = 1;
				num = 0;
			}
		}

		if (num > 0) {
			result = result + signs.pop() * sign * num;
		}
		return result;
	}
}
