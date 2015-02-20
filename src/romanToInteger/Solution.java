package romanToInteger;

public class Solution {
	public int romanToInt(String s) {
		int res = 0;
		for (int i = s.length() - 1; i > -1; i--) {
			char curr = s.charAt(i);
			switch (curr) {
			case 'I':
				if (res >= 5)
					res--;
				else
					res++;
				break;
			case 'V':
				if (res >= 10)
					res -= 5;
				else
					res += 5;
				break;
			case 'X':
				if (res >= 50)
					res -= 10;
				else
					res += 10;
				break;
			case 'L':
				if (res >= 100)
					res -= 50;
				else
					res += 50;
				break;
			case 'C':
				if (res >= 500)
					res -= 100;
				else
					res += 100;
				break;
			case 'D':
				res += 500;
				break;
			case 'M':
				res += 1000;
				break;
			default:
				break;
			}
		}
		return res;
	}
}
