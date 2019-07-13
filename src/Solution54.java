import java.util.ArrayList;
import java.util.List;

public class Solution54 {
	

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ls = new ArrayList<>();
		if (matrix == null || matrix.length < 1) {
			return ls;
		}
		if (matrix[0] == null || matrix[0].length < 1) {
			return ls;
		}

		int tc = 0;
		int tr = 0;
		int dr = matrix.length - 1;
		int dc = matrix[0].length - 1;
		while (tr <= dr && tc <= dc) {
			getOrder(matrix, ls, tr++, tc++, dr--, dc--);
		}
		return ls;

	}

	private void getOrder(int[][] matrix, List<Integer> ls, int tr, int tc, int dr, int dc) {
		// TODO Auto-generated method stub
		if (tr == dr) {// 当前矩阵只有一行
			for (int i = tc; i <= dc; i++) {
				ls.add(matrix[tr][i]);
			}
		} else if (tc == dc) {// 矩阵只有一列
			for (int i = tr; i <= dr; i++) {
				ls.add(matrix[i][tc]);
			}
		} else {// 一般情况
			int curR = tr;
			int curC = tc;
			while (curC < dc) {
				ls.add(matrix[tr][curC++]);

			}
			while (curR < dr) {
				ls.add(matrix[curR++][dc]);
			}
			while (curC > tc) {
				ls.add(matrix[dr][curC--]);
			}
			while (curR > tr) {
				ls.add(matrix[curR--][tc]);
			}

		}
	}
}
