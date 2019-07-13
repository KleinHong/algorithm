import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
	public List<List<Integer>> threeSum(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> num_set = new ArrayList<>();
		if(nums.length<3 || nums[0]>0) return num_set;
		for(int k=0;k<nums.length;k++) {
			if (k > 0 && nums[k] == nums[k - 1]) continue;
			int l=k+1,r=nums.length-1,sum=0;
			sum=0-nums[k];
			while(l<r) {
				if(nums[l]+nums[r]==sum) {
					num_set.add(Arrays.asList(nums[k],nums[l],nums[r]));
				while(l<r && nums[l]==nums[l+1]) ++l;
				while(l<r && nums[l]==nums[r-1]) --r;
				++l;
				--r;
				}
				else if(nums[l]+nums[r]<sum) {
					l++;
				}
				else
					r--;
			}
		}
		return num_set;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -1, 0, 1, 2, -1, 0,0 };
		Solution15 s = new Solution15();
		System.out.println(s.threeSum(nums));

	}
}
