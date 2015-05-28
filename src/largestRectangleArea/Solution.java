package largestRectangleArea;

import java.util.Stack;

public class Solution {
	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;
		int max = 0;
		while (i < height.length) {
			// push index to stack when the current height is larger than the
			// previous one
			if (stack.empty() || height[i] > height[stack.peek()]) {
				stack.push(i);
				i++;
			} else {
				int p = stack.pop();
				int h = height[p];
				int w = stack.empty() ? i : i - stack.peek() - 1;
				max = Math.max(h * w, max);
			}
		}
		while (!stack.empty()) {
			int p = stack.pop();
			int h = height[p];
			int w = stack.empty() ? i : i - stack.peek() - 1;
			max = Math.max(h * w, max);
		}
		return max;
	}
}
