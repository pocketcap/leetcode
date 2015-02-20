package longestCommonPrefix;

public class Solution {
	public String longestCommonPrefix(String[] args) {
		if (args.length == 0)
			return "";
		for (int i = 0; i < args.length - 1; i++) {
			String curr = args[i];
			String curr_pref = "";
			if (args[i].length() > args[i + 1].length()) {
				curr = args[i + 1];
			}
			for (int j = 0; j < curr.length(); j++) {
				if (args[i].charAt(j) != args[i + 1].charAt(j))
					break;
				else
					curr_pref += args[i].charAt(j);
			}
			args[i + 1] = curr_pref;
		}
		return args[args.length - 1];
	}
}
