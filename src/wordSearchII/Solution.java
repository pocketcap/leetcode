package wordSearchII;

import java.util.HashSet;
import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
	HashSet<String> result = new HashSet<String>();

	public ArrayList<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie();
		for (String word : words) {
			trie.insert(word);
		}

		int m = board.length;
		int n = board[0].length;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dfs(board, "", i, j, trie);
			}
		}
		return new ArrayList<String>(result);
	}

	public void dfs(char[][] board, String str, int i, int j, Trie trie) {
		int m = board.length;
		int n = board[0].length;

		if (i < 0 || j < 0 || i >= m || j >= n)
			return;

		if (board[i][j] == '#')
			return;

		str = str + board[i][j];

		if (!trie.startsWith(str))
			return;
		if (trie.search(str))
			result.add(str);
		char temp = board[i][j];
		board[i][j] = '#';
		dfs(board, str, i - 1, j, trie);
		dfs(board, str, i + 1, j, trie);
		dfs(board, str, i, j - 1, trie);
		dfs(board, str, i, j + 1, trie);
		board[i][j] = temp;
	}
}

class Trie {
	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	// Inserts a word into the trie.
	public void insert(String word) {
		HashMap<Character, TrieNode> children = root.children;
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			TrieNode t;
			if (children.containsKey(c))
				t = children.get(c);
			else {
				t = new TrieNode(c);
				children.put(c, t);
			}

			children = t.children;

			// set leaf node
			if (i == word.length() - 1)
				t.isLeaf = true;
		}
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		TrieNode t = searchNode(word);
		if (t != null && t.isLeaf)
			return true;
		else
			return false;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		if (searchNode(prefix) == null)
			return false;
		else
			return true;
	}

	public TrieNode searchNode(String str) {
		HashMap<Character, TrieNode> children = root.children;
		TrieNode t = null;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (children.containsKey(c)) {
				t = children.get(c);
				children = t.children;
			} else
				return null;
		}
		return t;
	}
}

class TrieNode {
	char c;
	HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	boolean isLeaf;

	public TrieNode() {
	}

	public TrieNode(char c) {
		this.c = c;
	}
}