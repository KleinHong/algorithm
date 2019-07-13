import java.util.ArrayList;
import java.util.List;

public class Solution52 {
	public int totalNQueens(int n) {
		if (n < 1) {
			return 0;
		}
		List<List<String>> rls = new ArrayList<List<String>>();
		int[] dp = new int[n];
		return process(0, dp, n);
		
	}

	private int process(int i, int[] dp, int n) {
		// TODO Auto-generated method stub
		if (i == n) {
			return 1;
		}
		int res=0;
		for (int index = 0; index < n; index++) {
			if (isValid(dp, i, index)) {
				dp[i] = index;
				res+=process(i + 1, dp, n);
			}
		}
		return res;

	}

	private boolean isValid(int[] dp, int i, int index) {
		// TODO Auto-generated method stub
		for (int k = 0; k < i; k++) {
			if (index == dp[k] || Math.abs(dp[k] - index) == Math.abs(i - k)) {// �жϵ�ǰ���Ƿ��лʺ󣬻���б�����Ƿ��лʺ�
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Solution52 s52=new Solution52();
		System.out.println(s52.totalNQueens(4));
	}
}
