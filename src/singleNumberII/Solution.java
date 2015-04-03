package singleNumberII;

/**
 * reference: http://yucoding.blogspot.com/2014/10/single-number-ii.html
 * 
 */

public class Solution {
	public int singleNumber(int[] A) {
		int ones = 0;
		int twos = 0;
		int threes = 0;
		for (int a : A) {
			twos = twos | (a & ones);
			ones = ones ^ a;
			threes = ones & twos;
			ones = ones & ~threes;
			twos = twos & ~threes;
		}
		return ones;
	}
}
