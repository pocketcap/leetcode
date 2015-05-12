package spiralOrder;

import java.util.List;
import java.util.ArrayList;

public class Solution {
	public List<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		if (matrix == null || matrix.length == 0)
			return result;
		int m = matrix.length;
		int n = matrix[0].length;

		// start point
		int x = 0;
		int y = 0;

		while (m > 0 && n > 0) {
			// only one row/column
			if (m == 1) {
				for (int i = 0; i < n; i++) {
					result.add(matrix[x][y++]);
				}
				break;
			} else if (n == 1) {
				for (int i = 0; i < m; i++) {
					result.add(matrix[x++][y]);
				}
				break;
			}

			// top: left - right
			for (int i = 0; i < n - 1; i++) {
				result.add(matrix[x][y++]);
			}

			// right: up-down
			for (int i = 0; i < m - 1; i++) {
				result.add(matrix[x++][y]);
			}
			// bottom: left- right
			for (int i = 0; i < n - 1; i++) {
				result.add(matrix[x][y--]);
			}
			// left: down-up
			for (int i = 0; i < m - 1; i++) {
				result.add(matrix[x--][y]);
			}
			x++;
			y++;
			m -= 2;
			n -= 2;
		}
		return result;
	}
}
