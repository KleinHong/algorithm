

public class Solution26 {

	public Solution26() {
		// TODO Auto-generated constructor stub
	}
    public int removeDuplicates(int[] nums) {
    	int left=0,right;
    	if(nums.length<=0) return 0;
    	for(right=0;right<nums.length;right++) {
    		if(nums[left]!=nums[right]) {
    			left++;
    			nums[left]=nums[right];
    		}
    	}
    	return left;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {0,1,1,5,5,6,7,7,9,9,9};
		Solution26 s=new Solution26();
		//s.removeDuplicates(nums);
		System.out.print(s.removeDuplicates(nums));
	}

}
