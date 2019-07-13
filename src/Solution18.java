import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution18 {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		List<List<Integer>> num_set = new ArrayList<>();
		if (nums.length < 4 || nums[0] > 0)
			return num_set;
		for (int i = 0; i < nums.length; i++) {
			if (i > 1 && nums[i] == nums[i - 1])
				continue;
			int sum=target;
			sum=sum-nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				
				if (j > i+1 && nums[j] == nums[j - 1])//注意这个小错误
					continue;
				int l = j + 1, r = nums.length - 1;
				sum = sum - nums[j];
				while (l < r) {
					if (nums[l] + nums[r] == sum) {
						num_set.add(Arrays.asList(nums[i],nums[j], nums[l], nums[r]));
						while (l < r && nums[l] == nums[l + 1])
							++l;
						while (l < r && nums[l] == nums[r - 1])
							--r;
						++l;
						--r;
	
					} else if (nums[l] + nums[r] <sum) {
						l++;
					} else
						r--;
				}
				sum=sum+nums[j];
			}
			sum=sum+nums[i];
		}
		return num_set;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {-1,0,0,0,0,0,1};
		Solution18 s = new Solution18();
		System.out.println(s.fourSum(nums, 0));
	}

}
