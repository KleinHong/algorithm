
public class Solution53 {
public int maxSubArray(int[] nums) {
        if(nums==null || nums.length<1) {
        	return Integer.MIN_VALUE;
        }
        if(nums.length==1) {
        	return nums[0];
        }
        
        int r=0;
        int cur=0;
        int sum=Integer.MIN_VALUE;
        while(r<nums.length) {
        	cur+=nums[r];
        	sum=Math.max(sum, cur);
        	cur=cur<0?0:cur;
        	r++;
        }
        return sum;
    }

public static void main(String[] args) {
	int [] nums= {-2,1,-3,4,-1,2,1,-5,4};
	Solution53 s53= new Solution53();
	System.out.println(s53.maxSubArray(nums));
}
}
