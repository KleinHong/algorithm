import java.util.Arrays;

public class Solution27 {

	public Solution27() {
		// TODO Auto-generated constructor stub
	}
    public int removeElement(int[] nums, int val) {
    	int left=0,right=nums.length-1;
    	while(left<=right) {
    		if(nums[left]==val) {
    			nums[left]=nums[right];
    			right--;
    		}
    		else
    			left++;
    	}
    	return left;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums= {3,2,2,3};
		Solution27 s=new Solution27();
		//s.removeDuplicates(nums);
		System.out.print(s.removeElement(nums, 3));
	}

}
