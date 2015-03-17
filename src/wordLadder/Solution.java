package wordLadder;

import java.util.LinkedList;
import java.util.Set;

public class Solution {
	public int ladderLength(String start, String end, Set<String> dict) {
		if (dict.size() == 0)
			return 0;

		dict.add(end);

		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();

		wordQueue.add(start);
		distanceQueue.add(1);

		int result = Integer.MAX_VALUE;
		while (!wordQueue.isEmpty()) {
			String currWord = wordQueue.pop();
			Integer currDistance = distanceQueue.pop();

			if (currWord.equals(end)) {
				result = Math.min(result, currDistance);
				break;
			}

			for (int i = 0; i < currWord.length(); i++) {
				char[] currCharArr = currWord.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					currCharArr[i] = c;
					String newWord = new String(currCharArr);
					if (dict.contains(newWord)) {
						wordQueue.add(newWord);
						distanceQueue.add(currDistance + 1);
						dict.remove(newWord);
					}
				}
			}
		}
		if (result < Integer.MAX_VALUE)
			return result;
		else
			return 0;
	}
}
