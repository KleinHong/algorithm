
public class Solution63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid == null || obstacleGrid.length < 1) {
			return 0;
		}
		int r = obstacleGrid.length;
		int c = obstacleGrid[0].length;
		int[][] dp = new int[r][c];
		dp[0][0] = obstacleGrid[0][0] == 0 ? 1 : 0;
		if (dp[0][0] == 0) {
			return 0;
		}
		for (int i = 1; i < c; i++) {
			if (obstacleGrid[0][i] == 0) {
				dp[0][i] = dp[0][i - 1];
			}
		}
//		if(r==1) {
//			return dp[0][c-1];
//		}

		for (int j = 1; j < r; j++) {
			if (obstacleGrid[j][0] == 0) {
				dp[j][0] = dp[j - 1][0];
			}
		}

		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if (obstacleGrid[i][j] == 0) {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}
		return dp[r - 1][c - 1];
	}
	
	public static void main(String[] args) {
		int[][] nums= {{0,1,0,0,0},{1,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
		Solution63 s63=new Solution63();
		System.out.println(s63.uniquePathsWithObstacles(nums));
		 
	}
}
