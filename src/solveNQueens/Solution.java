package solveNQueens;

import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<List<String>> solveNQueens(int n) {
		char[][] board = new char[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j] = '.';
			}
		}
		List<List<String>> res = new ArrayList<List<String>>();
		dfs(board, 0, res);
		return res;
	}

	public void dfs(char[][] board, int col, List<List<String>> res) {
		if (col == board.length) {
			res.add(construct(board));
			return;
		}

		for (int j = 0; j < board.length; j++) {
			if (validate(board, col, j)) {
				board[col][j] = 'Q';
				dfs(board, col + 1, res);
				board[col][j] = '.';
			}
		}
	}

	public boolean validate(char[][] board, int x, int y) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < board.length; j++) {
				if (board[i][j] == 'Q'
						&& (x + j == y + i || x + y == i + j || j == y))
					return false;
			}
		}
		return true;
	}

	public List<String> construct(char[][] board) {
		List<String> res = new ArrayList<String>();
		for (int i = 0; i < board.length; i++) {
			String s = new String(board[i]);
			res.add(s);
		}
		return res;
	}
}
