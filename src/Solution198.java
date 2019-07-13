
public class Solution198 {
	public int rob(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}
		if (nums.length == 1) {
			return nums[0];
		}
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(dp[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			// 每偷窃一家判断偷或者不偷那个值比较大
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return dp[nums.length - 1];

	}
}
