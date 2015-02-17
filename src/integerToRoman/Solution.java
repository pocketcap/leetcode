package integerToRoman;

import java.util.HashMap;

/**
 * Given an integer, convert it to a roman numeral.
 * 
 * Input is guaranteed to be within the range from 1 to 3999.
 * 
 */

public class Solution {
	public String intToRoman(int num) {
		String res = "";
		String[] romanNumbers = { "M", "CM", "D", "CD", "C", "XC", "L", "XL",
				"X", "IX", "V", "IV", "I" };
		int[] val = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		for (int i = 0; i < val.length; i++) {
			for (int j = 0; j < num / val[i]; j++) {
				res += romanNumbers[i];
			}
			num = num % val[i];
		}
		return res;
	}
}
