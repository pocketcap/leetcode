package addAndSearchWord;

import java.util.Map;
import java.util.HashMap;

public class WordDictionary {
	private TrieNode root;

	public WordDictionary() {
		root = new TrieNode();
	}

	// Add a word into the data structure
	public void addWord(String word) {
		HashMap<Character, TrieNode> children = root.children;

		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);

			TrieNode t = null;
			if (children.containsKey(c)) {
				t = children.get(c);
			} else {
				t = new TrieNode(c);
				children.put(c, t);
			}
			children = t.children;

			if (i == word.length() - 1)
				t.isLeaf = true;
		}
	}

	// Returns if the word is in the data structure. A word could
	// contain the dot character '.' to represent any one letter.
	public boolean search(String word) {
		return dfsSearch(root.children, word, 0);
	}

	public boolean dfsSearch(HashMap<Character, TrieNode> children,
			String word, int start) {
		if (start == word.length())
			return false;

		char c = word.charAt(start);

		if (children.containsKey(c)) {
			if (start == word.length() - 1 && children.get(c).isLeaf) {
				return true;
			}

			return dfsSearch(children.get(c).children, word, start + 1);
		} else if (c == '.') {
			for (Map.Entry<Character, TrieNode> child : children.entrySet()) {
				if (start == word.length() - 1 && child.getValue().isLeaf)
					return true;

				// if any path is true, set result to be true
				if (dfsSearch(child.getValue().children, word, start + 1))
					return true;
			}
			return false;
		} else
			return false;
	}
}

class TrieNode {
	char c;
	HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	boolean isLeaf;

	public TrieNode() {
	};

	public TrieNode(char c) {
		this.c = c;
	}
}