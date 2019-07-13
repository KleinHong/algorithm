import java.util.Arrays;

public class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        int diff,newdiff;
		if(nums.length<3) return 0 ;
		int sum0=0;
        diff=Math.abs(target-nums[0]-nums[1]-nums[2]);
		Arrays.sort(nums);
		for(int k=0;k<nums.length-2;k++) {
			int l=k+1,r=nums.length-1,sum=0;
			while(l<r) {
				sum=nums[k]+nums[l]+nums[r];
				newdiff=Math.abs(target-sum);
				if(diff>=newdiff) {
					diff=newdiff;
					sum0=sum;
				}
				if(sum<target) {
					l++;
				}
				else
					r--;
			}
		}
		return sum0;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0,2,1,-3};
		Solution16 s = new Solution16();
		System.out.println(s.threeSumClosest(nums,1));

	}
}
