package addDigits;

/**
 * reference: http://bookshadow.com/weblog/2015/08/16/leetcode-add-digits/
 * 
 */

public class Solution {
	public int addDigits(int num) {
		if (num == 0)
			return num;

		return (num - 1) % 9 + 1;
	}
}
