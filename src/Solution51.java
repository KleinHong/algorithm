import java.util.ArrayList;
import java.util.List;

public class Solution51 {
	public List<List<String>> solveNQueens(int n) {
		if (n < 1) {
			return null;
		}
		List<List<String>> rls = new ArrayList<List<String>>();
		int[] dp = new int[n];
		process(0, dp, rls, n);
		return rls;
	}

	private void process(int i, int[] dp, List<List<String>> rls, int n) {
		// TODO Auto-generated method stub
		if (i == n) {
			List<String> ls = new ArrayList<String>();
			for (int j = 0; j != n; j++) {
				StringBuilder sb = new StringBuilder();
				for (int k = 0; k < n; k++) {
					if (k == dp[j]) {
						sb.append('Q');
					} else {
						{
							sb.append('.');
						}
					}
				}
				ls.add(sb.toString());
			}
			rls.add(ls);
		}

		for (int index = 0; index < n; index++) {
			if (isValid(dp, i, index)) {
				dp[i] = index;
				process(i + 1, dp, rls, n);
			}
		}

	}

	private boolean isValid(int[] dp, int i, int index) {
		// TODO Auto-generated method stub
		for (int k = 0; k < i; k++) {
			if (index == dp[k] || Math.abs(dp[k] - index) == Math.abs(i - k)) {// 判断当前列是否有皇后，或者斜线上是否有皇后
				return false;
			}
		}
		return true;
	}
}
