
public class Solution59 {

	public int[][] generateMatrix(int n) {
		if (n < 1) {
			return null;
		}
		int[][] matrix = new int[n][n];
		getMatrix(matrix, n);
		return matrix;

	}

	private void getMatrix(int[][] matrix, int n) {
		int tr = 0;
		int tc = 0;
		int dr = n - 1;
		int dc = n - 1;
		int index = 1;

		while (tr < dr && tc < dc) {
			int curR = tr;
			int curC = tc;
			while (curC < dc) {
				matrix[tr][curC++] = index++;
			}
			while (curR < dr) {
				matrix[curR++][dc] = index++;
			}
			while (curC > tc) {
				matrix[dr][curC--] = index++;
			}
			while (curR > tr) {
				matrix[curR--][tc] = index++;
			}
			tr++;
			tc++;
			dr--;
			dc--;
		}
		if (tr == dr && tc == dc) {
			matrix[tr][tc] = index;
		}
	}

	public static void main(String[] args) {
		Solution59 s59 = new Solution59();
		int[][] nums = s59.generateMatrix(5);
		for (int[] arr : nums) {
			for (int c : arr) {
				System.out.print(c + " ");
			}
			System.out.println();
		}
	}
}
