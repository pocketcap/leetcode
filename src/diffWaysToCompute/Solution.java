package diffWaysToCompute;

import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<Integer>();
		if (input == null || input.length() == 0)
			return result;

		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c != '+' && c != '-' && c != '*')
				continue;

			List<Integer> p1 = diffWaysToCompute(input.substring(0, i));
			List<Integer> p2 = diffWaysToCompute(input.substring(i + 1,
					input.length()));

			for (Integer m : p1) {
				for (Integer n : p2) {
					if (c == '+')
						result.add(m + n);
					else if (c == '-')
						result.add(m - n);
					else
						result.add(m * n);
				}
			}
		}

		if (result.size() == 0)
			result.add(Integer.valueOf(input));

		return result;
	}
}
