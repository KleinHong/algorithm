
public class Solution45 {
	public int jump(int[] nums) {
		if (nums == null || nums.length < 1) {
			return 0;
		}

		int jump = 0;
		int cur = 0;
		int next = 0;
		for (int i = 0; i != nums.length; i++) {
			if (cur < i) { 
				jump++;     //cur代表当前跳跃步数最高能到达的位置；如果
				cur = next; //不能抵达当前位置i；代表我们必须多跳一次			
			}
			//next代表下一步能跳的最大位置，是整个算法的精髓
			next = Math.max(next, i + nums[i]);
			
		}
		return jump;
	}

	public static void main(String[] args) {
		Solution45 s45 = new Solution45();
		int[] nums = { 2, 3, 1, 1, 4 };
		System.out.println(s45.jump(nums));
	}
}
